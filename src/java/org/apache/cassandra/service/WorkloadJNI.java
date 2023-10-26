/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.service;

// import java.io.IOException;

// import org.apache.cassandra.config.DatabaseDescriptor;
// import org.apache.cassandra.transport.SimpleClient;

public class WorkloadJNI{
   static {
      System.loadLibrary("workload");
   } 

   private native void sayHello();

   public static void main() {
    new WorkloadJNI().sayHello();
   }


   public static void javafromC() {
      // SimpleClient client;
      System.out.println("Hello world from JAVA");
      // try {
      //    // I think this is failing because it 
      //    // is trying to do it before the cassandra server is running
      //    ///////
      //    // - add a c++ grpc
      //    // - Put this stuff in a grpc call
      //    // - have this be accessed by grpc 
      //    // - *Then* run this 
      //    DatabaseDescriptor.clientInitialization();
      //    // final DatabaseDescriptor settings;
      //    client = new SimpleClient("localhost", 7000);
      //    client.connect(false);
      //    client.execute("CREATE KEYSPACE new_keyspace WITH replication = {'class':'SimpleStrategy'}", org.apache.cassandra.db.ConsistencyLevel.ONE);
      //    client.close();
      // } catch (IOException e) {
      //    throw new RuntimeException(e.getMessage());
      // }

      // While ready waiting on an rpc do the op stuff ?
      // while (true) {
      // how do we get an operation
      // }

   }
}
