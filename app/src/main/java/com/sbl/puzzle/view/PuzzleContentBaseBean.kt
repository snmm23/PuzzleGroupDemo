package com.sbl.puzzle.view

import java.io.Serializable

data class PuzzleContentBaseBean<T>(val row: Int,
                                 val col: Int,
                                 val rowSpan: Int,
                                 val colSpan: Int) : Serializable
{
    var contentData: T? = null

}
