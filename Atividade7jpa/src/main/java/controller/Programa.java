package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Automovel;
import entities.Marca;
import entities.Modelo;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade7jpa");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Marca marca = new Marca();
			marca.setNome("Chevrolet");

			Modelo modelo = new Modelo();
			modelo.setDescricao("Classic");
			modelo.setPotencia(200);
			modelo.setMarca(marca);

			Automovel automovel = new Automovel();
			automovel.setAnoFabricacao(2020);
			automovel.setAnoModelo(2020);
			automovel.setObservacao("Preto fosco");
			automovel.setPreco(50000.0f);
			automovel.setKilometragem(10000);
			automovel.setModelo(modelo);

			em.persist(marca);
			em.persist(modelo);
			em.persist(automovel);

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
