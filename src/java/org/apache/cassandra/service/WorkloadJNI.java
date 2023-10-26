package org.apache.cassandra.service;

import java.io.IOException;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.transport.SimpleClient;

public class WorkloadJNI{
   static {
      System.loadLibrary("hello");
   } 

   private native void sayHello();

   public static void main() {
    new WorkloadJNI().sayHello();
   }


   public static void javafromC() {
      SimpleClient client;
      System.out.println("Hello world from JAVA");
      try {
         // I think this is failing because it 
         // is trying to do it before the cassandra server is running
         ///////
         // - add a c++ grpc
         // - Put this stuff in a grpc call
         // - have this be accessed by grpc 
         // - *Then* run this 
         DatabaseDescriptor.clientInitialization();
         // final DatabaseDescriptor settings;
         client = new SimpleClient("localhost", 7000);
         client.connect(false);
         client.execute("CREATE KEYSPACE new_keyspace WITH replication = {'class':'SimpleStrategy'}", org.apache.cassandra.db.ConsistencyLevel.ONE);
         client.close();
      } catch (IOException e) {
         throw new RuntimeException(e.getMessage());
      }

      // While ready waiting on an rpc do the op stuff ?
      // while (true) {
      // how do we get an operation
      // }

   }
}
