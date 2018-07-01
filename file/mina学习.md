## 1:mina 有哪些应用

主要屏蔽了网络通信的的一些细节，对socket进行封装，是nio的一个实现架构，可用于游戏开发，中间件等服务端程序

## 2: 接口

IOService 用于描述服务端和客户端的接口，其子类是acceptor,和connector,分别用于服务端和客户端

IOProcessor 多线程环境来处理连接请求流程

IOFilter 提供数据的过滤工作：包括编码，解码，日志等信息的过滤

Handler 业务对象，自定义的handler需要实现IOHandlerAcceptor

## 3 :长短连接

长连接：通讯双发长期的保持一个连接状态，例如qq 会话

短连接 ：通讯双方不是保持一个长期的连接状态，例如http请求

## 4 :IOFilter 

可以自定义过滤器

## 5 :IOSession 

IOSession可以完成对于连接的一些管理，可以发送或者读取数据，可以设置会话的上下文信息

IOSessionConfig 可以提供连接信息的描述，读缓冲区的设置，读写的空闲时间，超时时间

## 6: 线程模型

 processor : 是以NIO为基础的实现多线程的方式来完成读写的

作用：提供一个非阻塞式的多线程环境

通过NioSocketAcceptor(int processorCount) ，NioSocketConnector(int processorCount) 构造函数可以指定多线程的个数



