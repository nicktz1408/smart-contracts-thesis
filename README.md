# "Smart Contracts Compilation" Thesis
This repository contains the code that is part of my BSc Thesis titled "Smart Contracts Compilation". I developed a compiler which converts programs written using the [Accord Project](https://github.com/accordproject) tools, which is a framework dedicated to coding smart contracts powered by blockchain technology, to [Symboleo](https://github.com/smart-Contract-Modelling-uOttawa/Symboleo-IDE), a descriptive language used to express smart contracts and is developed by the CSM Lab at U of Ottawa EECS department.

In order to accomplish the compilation, I used the XText library, based on the Java programming language, which enables users to write expressive  context-free gramar rules and provides tools for text generation based on the provided grammar, which suits perfectly our use case of generating code on a target format (in our case, code in the Symboleo language).

More information can be found in my [Thesis report](https://docs.google.com/document/d/1j9vOttrx6hteMdBt1KOb4ztw4A5dkHEEeaUVgYbEmIQ/edit?usp=sharing), currently in Greek, but in the future will try to translate it to English.
