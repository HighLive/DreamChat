from flask import Flask, render_template, request, jsonify
from pymongo import MongoClient

app = Flask(__name__)
client = MongoClient('localhost', 27017)
db = client.myDB

## HTML을 주는 부분
@app.route('/')
def home():
   return render_template('index.html')

## POST 요청 API 구현
@app.route('/review', methods = ['POST'])
def write_review():
    title_receive = request.form['title_give']
    author_receive = request.form['author_give']
    review_receive = request.form['review_give']

    ## DB에 삽입할 review 딕셔너리 만들기
    doc = {
        'title': title_receive,
        'author': author_receive,
        'review': review_receive
    }
    
    db.bookreview.insert_one(doc)
    return jsonify({'msg':'리뷰가 성공적으로 작성되었습니다.'})

## GET 요청 API 구현
@app.route('/review', methods=['GET'])
def read_reviews():
    # 서버는 클라이언트로부터 데이터를 받을 필요x.
    # 모든 리뷰를 DB로부터 가져와 내려주기만 하면됨.
    reviews = list(db.bookreview.find({}, {'_id': False}))

    return jsonify({'all_reviews': reviews})
    
if __name__ == '__main__':
   app.run('0.0.0.0',port=5000,debug=True)