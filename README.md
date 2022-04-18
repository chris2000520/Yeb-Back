# 线上办公系统后端

## MySQL

导入数据库文件，生成相关表， 配置自己的数据库名称和密码

## Redis

在本地开启Redis服务

```
redis-server.exe redis.windows.conf
redis-cli.exe -h 127.0.0.1 -p 6379
```

## RabbitMQ

进入 D:\rabbitmq_server-3.6.6\sbin ，双击 rabbitmq-server.bat 会打开一个窗口，启动完成后这个窗口不能关闭。或者将其添加到环境变量，直接运行：

```
rabbitmq-server
```

## 接口文档
http://localhost:8081/doc.html

## 异常和缺陷

更新登录用户信息异常

修改密码未实现

修改用户头像未实现
