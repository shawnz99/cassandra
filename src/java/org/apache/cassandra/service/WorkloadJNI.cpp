#include <jni.h>
#include <iostream>
#include "org_apache_cassandra_service_WorkloadJNI.h"

using namespace std;

JavaVM *jvm;

//////////////////
//
// The workloads would be implemented here
//
///////////////
 
JNIEXPORT void JNICALL Java_org_apache_cassandra_service_WorkloadJNI_sayHello(JNIEnv *env, jobject thisObj) {
    //jclass stressTestClass = env -> FindClass("org/apache/cassandra/stress");
    // jobject newObject = env -> AllocObject(stressTestClass);
    env -> GetJavaVM(&jvm);
    // for each of the threads have some one 
    jvm -> AttachCurrentThread((void **)&env, NULL);

    jclass jcls = env -> FindClass("org/apache/cassandra/service/WorkloadJNI");
    if (jcls == nullptr) {
        cerr << "ERROR: class not found!";
    } else {
        jmethodID m_id = env->GetStaticMethodID(jcls, "javafromC", "()V");
        if (m_id == nullptr) {
            cerr << "ERROR: method void javafrmC() not foind !" << endl;
        } else {
            env -> CallStaticVoidMethod(jcls, m_id);
        }
        cout << "Hello World from java thread" << endl;
    }

    jvm->DetachCurrentThread();
    cout << "Hello World from c++" << endl;
    return;
}
