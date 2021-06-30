# PuzzleGroupDemo
实现自定义动态布局，可根据数组角标控制Item位置。

预览：

![png](https://github.com/snmm23/PuzzleGroupDemo/blob/master/pic/screenshot.png)

可根据动态数组来控制布局摆放，Demo以图片数据为例进行显示，可动态替换其他数据



Data：

(起始行，起始列，占用行单元格，占用列单元格)

Demo数据如下：

(0, 0, 1, 1),

(0, 1, 1, 5),

(1, 0, 3, 3),

(1, 3, 2, 3),

(3, 3, 1, 3),

(4, 0, 3, 2),

(4, 2, 2, 2),

(4, 4, 2, 1),

(7, 0, 1, 3),

(6, 2, 1, 1),

(6, 3, 2, 2),

(4, 5, 4, 1)



方法介绍：

初始化时需传入共几行，共几列参数

setGridSpacing设置Item间距

setGridSpacingColor设置间距颜色

setAdapter设置内容适配器

