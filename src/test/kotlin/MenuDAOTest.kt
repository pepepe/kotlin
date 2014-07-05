/**
 * Created by pepepe on 2014/07/05.
 */

import entity.MenuDAO

fun main(args:Array<String>) {
    MenuDAO().findAllMenu().forEach {
        menu -> println("${menu.name} --- \\${menu.price}")
    }
}