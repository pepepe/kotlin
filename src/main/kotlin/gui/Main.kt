package gui

import entity.MenuDAO
import javafx.application.Application
import javafx.stage.Stage
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.Parent

fun main(args : Array<String>) {
    val dao : MenuDAO = MenuDAO()
    dao.findAllMenu()?.forEach { menu -> println(menu?.name) }
    Application.launch(MenuView().javaClass)
}

class MenuView() : Application() {
    override fun start(stage: Stage?) {
        val parent: Parent? = FXMLLoader.load(getClass().getResource("/Main.fxml"))
        stage?.setTitle("メニュー")
        stage?.setScene(Scene(parent))
        stage?.show()
    }
}