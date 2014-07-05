package gui

import javafx.fxml.FXML
import javafx.scene.control.TextField
import javafx.scene.control.TableView
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.PropertyValueFactory
import javafx.collections.FXCollections
import entity.Menu
import entity.MenuDAO

class MenuController() {
    val dao: MenuDAO = MenuDAO()
    [FXML] var menuText: TextField? = null
    [FXML] var priceText: TextField? = null
    [FXML] var menuTable: TableView<Menu>? = null
    [FXML] var menuCol: TableColumn<Menu, String>? = null
    [FXML] var priceCol: TableColumn<Menu, Int>? = null

    [FXML] fun initialize(): Unit {
        menuCol?.setProperty("name")
        priceCol?.setProperty("price")
//        menuCol?.setCellValueFactory(PropertyValueFactory<Menu, String>("name"))
//        priceCol?.setCellValueFactory(PropertyValueFactory<Menu, Int>("price"))
        refresh()
    }

    fun refresh() {
        val menus = FXCollections.observableList(dao.findAllMenu())
        menuTable?.setItems(menus)
    }

    fun add(): Unit {
        val menu: Menu = Menu()
        menu.name = menuText?.getText() as String
        menu.price = priceText?.getText()?.toInt() as Int
        dao.create(menu)

        refresh()
    }

    fun delete(): Unit {
        val menu: Menu? = menuTable?.getSelectionModel()?.getSelectedItem()
        dao.delete(menu)

        refresh()
    }

    fun <T, S> TableColumn<S, T>.setProperty(property: String) {
        setCellValueFactory(PropertyValueFactory<S, T>(property))
    }
}


