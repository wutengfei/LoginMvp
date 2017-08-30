一、概述

对于MVP（Model View Presenter），大多数人都能说出一二：“MVC的演化版本”，“让Model和View完全解耦”等等。本篇博文仅是为了做下记录，提出一些自己的看法，和帮助大家如何针对一个Activity页面去编写针对MVP风格的代码。

对于MVP，我的内心有一个问题：

    为何这个模式出来后，就能被广大的Android的程序员接受呢？

问了些程序员，他们对于MVP的普遍的认识是：“代码很清晰，不过增加了很多类”。我在第一次看到MVP的时候，看了一个demo，看完以后觉得非常nice（但是回过头来，自己想个例子写，就头疼写不出来，当然这在后文会说）。nice的原因还是因为，这个模式的确让代码的清晰度有了很大的提升。

那么，提升一般都是对比出来的，回顾下，没有应用MVP的代码结构。很多人说明显是MVC么：

    View：对应于布局文件
    Model：业务逻辑和实体模型
    Controllor：对应于Activity

看起来的确像那么回事，但是细细的想想这个View对应于布局文件，其实能做的事情特别少，实际上关于该布局文件中的数据绑定的操作，事件处理的代码都在Activity中，造成了Activity既像View又像Controller（当然了Data-Binder的出现，可能会让View更像View吧）。这可能也就是为何，在该文中有一句这样的话：

    Most of the modern android applications just use View-Model architecture，everything is connected with Activity.

而当将架构改为MVP以后，Presenter的出现，将Actvity视为View层，Presenter负责完成View层与Model层的交互。现在是这样的：

    View 对应于Activity，负责View的绘制以及与用户交互
    Model 依然是业务逻辑和实体模型
    Presenter 负责完成View于Model间的交互

ok，先简单了解下，文中会有例子到时候可以直观的感受下。

小总结下，也就是说，之所以让人觉得耳目一新，是因为这次的跳跃是从并不标准的MVC到MVP的一个转变，减少了Activity的职责，简化了Activity中的代码，将复杂的逻辑代码提取到了Presenter中进行处理。与之对应的好处就是，耦合度更低，更方便的进行测试。借用两张图（出自:该文），代表上述的转变：

转变为：

二、MVP 与 MVC 区别

ok，上面说了一堆理论，下面我们还是需要看一看MVC与MVP的一个区别，请看下图（来自：本文）:

其实最明显的区别就是，MVC中是允许Model和View进行交互的，而MVP中很明显，Model与View之间的交互由Presenter完成。还有一点就是Presenter与View之间的交互是通过接口的
