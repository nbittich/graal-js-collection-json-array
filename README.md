# Example 
demo bug  json array cannot be converted to a java collection.
If the type parameter is List, then it works.

see [test.js](test.js) for the javascript script being used for the demo.

### Exception
```
Exception in thread "main" Unsupported operation identifier 'iterator' and  object '(10)["b3c621f1-2e86-4d1f-b248-1113d88d9701", "09cda618-889d-4e7b-b985-328f47c65301", "cd46fb3e-e68d-436f-9335-831221e5e127", "3c64c92d-a0...'(language: JavaScript, type: Array). Identifier is not executable or instantiable.
        at com.oracle.truffle.polyglot.PolyglotEngineException.unsupported(PolyglotEngineException.java:147)
        at com.oracle.truffle.polyglot.PolyglotInteropErrors.invokeUnsupported(PolyglotInteropErrors.java:193)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandler$ProxyInvokeNode.invokeOrExecute(PolyglotObjectProxyHandler.java:261)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandler$ProxyInvokeNode.doCachedMethod(PolyglotObjectProxyHandler.java:214)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandlerFactory$ProxyInvokeNodeGen.executeAndSpecialize(PolyglotObjectProxyHandlerFactory.java:308)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandlerFactory$ProxyInvokeNodeGen.execute(PolyglotObjectProxyHandlerFactory.java:244)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandler$ObjectProxyNode.doDefault(PolyglotObjectProxyHandler.java:150)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandlerFactory$ObjectProxyNodeGen.executeAndSpecialize(PolyglotObjectProxyHandlerFactory.java:124)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandlerFactory$ObjectProxyNodeGen.executeImpl(PolyglotObjectProxyHandlerFactory.java:110)
        at com.oracle.truffle.polyglot.HostToGuestRootNode.execute(HostToGuestRootNode.java:124)
        at com.oracle.truffle.polyglot.PolyglotObjectProxyHandler.invoke(PolyglotObjectProxyHandler.java:105)
        at jdk.proxy1/jdk.proxy1.$Proxy20.iterator(Unknown Source)
        at com.example.demo.RandomService.randomStuffCollection(RandomService.java:12)
        at <js> process(Unnamed:6:145-198)
        at org.graalvm.polyglot.Value.execute(Value.java:881)
        at com.example.demo.DemoApplication.main(DemoApplication.java:32)
Caused by host exception: java.lang.UnsupportedOperationException: Unsupported operation identifier 'iterator' and  object '(10)["b3c621f1-2e86-4d1f-b248-1113d88d9701", "09cda618-889d-4e7b-b985-328f47c65301", "cd46fb3e-e68d-436f-9335-831221e5e127", "3c64c92d-a0...'(language: JavaScript, type: Array). Identifier is not executable or instantiable.
```
### Run the example:

- `docker build -t test .`
- `docker run --rm -ti  test`

