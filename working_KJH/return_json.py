from collections import OrderedDict
import json

# list(Json) 객체를 받아 ./temp.json 으로 저장
def LogToJson(log):
    index = 0
    result = OrderedDict()
    for l in log:
        for comment in l:
            msg = OrderedDict()
            index += 1

            msg['time'] = comment["content_offset_seconds"]
            msg['user_id'] = comment['commenter']['_id']
            msg['content'] = comment['message']['body']

            
            result["message" + str(index)] = msg

    with open("./temp.json", 'w') as outfile:
        json.dump(result, outfile, indent = 4, ensure_ascii=False)
    return 
