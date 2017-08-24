package helloworld;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Stateless
public class PessoaDAO {

	@PersistenceContext(unitName = "helloworld", type = PersistenceContextType.EXTENDED)
	EntityManager em;
	
	public Pessoa persisteDAO(Integer rg, String nome) {
		Pessoa p = new Pessoa(rg, nome);
		em.persist(p);
		return p;
	}
	
	public Pessoa mostraRgDAO(Integer rg) {
		return em.find(Pessoa.class, rg);
	}
	
	public void removeDAO(Integer rg) {
		em.remove(em.find(Pessoa.class, rg));
	}
	
	public Pessoa alteraDAO (Integer rg, String nome) {
		Pessoa p = em.find(Pessoa.class, rg);
		p.setNome(nome);
		em.merge(p);
		return p;
	}

}
