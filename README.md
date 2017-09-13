# BlankApp

[![Build Status](https://api.travis-ci.org/zhangjilei/BlankApp.svg?branch=master)](https://travis-ci.org/zhangjilei/BlankApp)


## 组件
- [Validation](https://github.com/zhangjilei/blankapp-validation)

## 如何使用

1、只需将 [mvn-repo](github.com/zhangjilei/mvn-repo/) 地址添加到您的项目根目录 build.gradle 文件：
```
repositories {
    maven { url 'https://raw.githubusercontent.com/zhangjilei/mvn-repo/master/' }
    jcenter()
}
```

2、在要集成的模块 build.gradle 文件中添加依赖，如下：
```
dependencies {
    compile 'org.blankapp:blankapp:0.0.11-alpha@aar'
}
```

## 编译

```
$ ./gradlew clean build uploadArchives 
```

## License


    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
