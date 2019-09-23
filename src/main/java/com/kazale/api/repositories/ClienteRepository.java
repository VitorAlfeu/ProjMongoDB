package com.kazale.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kazale.api.documents.Cliente;

//Cliente = Tipo da Classe que vai referenciar a Tabela e String = Tipo da variável ID da Classe
public interface ClienteRepository extends MongoRepository<Cliente, String> {

	//Query simples no MongoDB
	Cliente findByNome(String nome);

	//Query mais elaborada no MongoDB
	//Na consulta abaixo é pesquisada uma idade que seja gt (greater than ou maior do que) 0 e lt (lower than menor do que) 1
	@Query("{ 'idade' : { $gt: ?0, $lt: ?1 } }")
	List<Cliente> findByIdadeBetween(int idadeInicial, int idadeFinal);

}