import requests
import json

def getChatLog(video_id: str, client_id: str) -> list:
    next_cursor = ""
    params = {}
    params['client_id'] = client_id
    # client_id: f0tc0p4p3mifcdxtwi530swm2dsw0f

    chat_log = []
    log_cnt = 0

    # 한번의 Get요청에 약 57 ~ 59개의 comment에 대한 json파일을 load한다
    # next_cursor는 다음 채팅데이터를 가리키고 있음
    while True:
        URL = "https://api.twitch.tv/v5/videos/" + \
            video_id + "/comments?cursor=" + next_cursor

        response = requests.get(URL, params=params)
        chat_json = json.loads(response.text)
        chat_log.append(chat_json['comments'])

        try:
            next_cursor = chat_json["_next"]
            log_cnt += 1
        except KeyError:
            break

    return chat_log
