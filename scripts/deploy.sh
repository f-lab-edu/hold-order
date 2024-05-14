#!/usr/bin/env bash

REPOSITORY=/home/ubuntu/app

mkdir /home/ubuntu/app/log
echo "> 현재 구동 중인 애플리케이션 pid 확인" >> /home/ubuntu/app/log/deploy.log


CURRENT_PID=$(pgrep -fla java | grep hayan | awk '{print $1}')

echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID" >> /home/ubuntu/app/log/deploy.log

if [ -z "$CURRENT_PID" ]; then
  echo "현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다." >> /home/ubuntu/app/log/deploy.log
else
  echo "> kill -15 $CURRENT_PID" >> /home/ubuntu/app/log/deploy.log
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 애플리케이션 배포" >> /home/ubuntu/app/log/deploy.log

JAR_NAME=$(ls -tr $REPOSITORY/*SNAPSHOT.jar | tail -n 1)

echo "> JAR NAME: $JAR_NAME" >> /home/ubuntu/app/log/deploy.log

echo "> $JAR_NAME 에 실행권한 추가" >> /home/ubuntu/app/log/deploy.log

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행" >> /home/ubuntu/app/log/deploy.log

nohup java -jar -Duser.timezone=Asia/Seoul $JAR_NAME >> $REPOSITORY/nohup.out 2>&1 &
