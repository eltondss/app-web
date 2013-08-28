

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FabricaSessao {
	private static final SessionFactory sessionFactory; // Constante

	static {// tipo metodo main da classe, algo acessivel na aplicação.
		try {// Tenta instaniar a sessao
				// Tentara se conectar base de dados
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.buildServiceRegistry();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {// se nãpo der laça a excessao
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session abrirSessao() { // Toda vez que quiser se conectar ao
											// banco de dados basta abrir este
											// método
		return sessionFactory.openSession();
	}

}
