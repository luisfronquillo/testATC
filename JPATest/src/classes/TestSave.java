package classes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TipoATC;

import session.TipoATCFacade;

@ManagedBean(name = "testSave")
@SessionScoped
public class TestSave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5724267466317227314L;
	
	@EJB
    private TipoATCFacade ejbFacade;

	public TestSave() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void showListTipoATC(){
		
		List<TipoATC> list = new ArrayList<TipoATC>();
		
		list=ejbFacade.findAll();
		
		System.out.println("buscando  "+list.stream().filter(b -> "REEMBOLSO".equals(b.getTipoATC())).findFirst().orElse(null));
		list.stream().forEach(a->System.out.println(a +"  " + a.getTipoATC()));
		System.out.println("PRUEBA55555");
		
		
		
//		list.stream().filter(b -> b.getTipoATC().equals("REEMBOLSO"));
		
		
	}
}
