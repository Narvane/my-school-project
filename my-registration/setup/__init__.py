import py_eureka_client.eureka_client as eureka_client

your_rest_server_port = 8000
# The flowing code will register your server to eureka server and also start to send heartbeat every 30 seconds
eureka_client.init(eureka_server="http://my-service-discovery:8761",
                   app_name="my-registration",
                   instance_port=your_rest_server_port)
