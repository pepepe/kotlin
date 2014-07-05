package entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table

[Entity]
[Table(name = "MENUS")]
[NamedQuery(name = "Menu.findAll", query = "SELECT menu FROM Menu menu")]
public class Menu() {
    [Id]
    public var id : Int = 0
    public var name : String = ""
    public var price : Int = 0
}
