package entity

import javax.persistence.EntityManager
import javax.persistence.Persistence

class MenuDAO() {
    val em :EntityManager? = Persistence.createEntityManagerFactory("kotlin")!!.createEntityManager()

    fun findAllMenu(): List<Menu> {
        return em?.createNamedQuery("Menu.findAll", Menu().javaClass)?.getResultList() as List<Menu>
    }

    fun create(menu: Menu): Unit {
        em?.getTransaction()?.begin()
        em?.persist(menu)
        em?.getTransaction()?.commit()
    }

    fun delete(menu: Menu?): Unit {
        em?.getTransaction()?.begin()
        em?.remove(menu)
        em?.getTransaction()?.commit()
    }
}