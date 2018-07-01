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

## 7: IOBuffer 常用方法

基于NIO的ByteBuffer,可以操作缓冲区中数据，包括基本数据类型，和字节数组，本质是一个可以动态扩展的Byte数组

IOBuffer的索引属性

Capacity: 代表当前缓冲区的大小

Position: 可以理解为当前的位置，也可以是下一个可读数据单元的位置，（Position<=Capacity）的时候可以完成数据的读写

Limit ：下一个不可读写缓冲区单元的位置(Limit <=Capacity)

flip() : 让limit=position,position=0,为读取缓冲区数据做好准备

hasRemaining() : 缓冲区是否有数据，position<=limit 

Remaining () : 返回int ,返回缓冲区可读性数据的大小，limit-position

reset() : 清空数据

clear() : 数据覆盖 ；使position=0,重新开始读

## 8 ：自定义编码器，解码器

> #### 自定义编解码工厂，实现ProtocolCodecFactory接口
>
> #### 自定义解码器 ，实现ProtocolDecoder接口
>
> #### 自定义解码器, 实现ProtocolEncoder接口

## 9 常用自定义协议的方式

> #### 定长的方式 aa,bb,rf
>
> #### 定界符 hello|word|cc 会出现黏包 半包
>
> #### 自定义协议包 包头+包体
>
> 





