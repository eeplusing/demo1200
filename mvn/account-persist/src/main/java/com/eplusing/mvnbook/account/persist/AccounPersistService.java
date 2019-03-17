package com.eplusing.mvnbook.account.persist;

public interface AccounPersistService {
	Account createAccount(Account account) throws AccountPersistException;
	Account readAccount(String id) throws AccountPersistException;
	Account updateAccount(Account account) throws AccountPersistException;
	void deleteAccount(String id) throws AccountPersistException;
}
