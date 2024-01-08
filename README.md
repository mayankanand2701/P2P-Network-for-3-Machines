## Peer to Peer Network for 3 Machines 
Establishing a peer-to-peer network of three machines (H1, H2, DS) using UDP, H1 will connect to DS and fetch data and time. H2 should bring this data from H1. (H1 and H2 are two  hosts; DS is the daytime service provider)
# Features: 
- Fast Connection : A connection-less (fast) mechanism is used, which will allow two nodes to send and receive datagram packets. 
- UDP : A network address and a dynamic port are used.
- Time synchronization : Two nodes can check their time and zone differences using this daytime service provider.
