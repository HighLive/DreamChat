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
@app.route('/video_num', methods = ['POST'])
def write_review():
    
    return 

## GET 요청 API 구현
@app.route('/video_num', methods=['GET'])
def read_reviews():

    return 
    
if __name__ == '__main__':
   app.run('0.0.0.0',port=5000,debug=True)