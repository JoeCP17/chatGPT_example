# OpenAi Service 서드파티 라이브러리를 활용한 Chat GPT 연동 예제 

## 예제 제공 
- REST API를 활용한 Chat GPT 연동 ( 완 ) 
- WebSocket 활용한 Chat GPT 연동 ( 진행중 ) 


# Chat GPT Open API 내 Completion 

## Completion
- Chat GPT에 해당 문구를 통한 답변만 요청을 보내는 케이스 
   - 해당 요청으로 보내게 될 경우 우리가 이전 답변들에 대해서는 기록하지 않기에 대화형태로 이어서 말하는건 불가능하다. 
![image](https://user-images.githubusercontent.com/76832303/232110611-058e7362-0dc6-4997-a420-b94c2ba439e5.png)



## Completion Chat
- 위 사항과는 다르게 이전 답변에 대해서도 기록을 하기때문에 재 요청시 이전 답변들과 더불어 답변을 준다.

![스크린샷 2023-04-15 오전 2 06 17](https://user-images.githubusercontent.com/76832303/232111022-de36af7b-9d92-4b42-9583-fe28ac54fd1e.png)
![image](https://user-images.githubusercontent.com/76832303/232111079-55263ced-7d5a-43e2-bf17-5d952fe67ec7.png)

