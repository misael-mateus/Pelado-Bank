insert into cliente (id, cpf, email, nome, tipo_cliente) values (1, '554.488.741-63', 'email@email.com', 'Misael Mateus','NORMAL');
insert into cliente (id, cpf, email, nome, tipo_cliente) values (2, '751.288.744-56', 'email@email.com', 'Simone','NORMAL');
insert into cliente (id, cpf, email, nome, tipo_cliente) values (3, '254.488.721-66', 'email@email.com', 'João','NORMAL');
insert into cliente (id, cpf, email, nome, tipo_cliente) values (4, '151.188.141-13', 'email@email.com', 'Joaquina','NORMAL');
insert into cliente (id, cpf, email, nome, tipo_cliente) values (5, '131.388.341-33', 'email@email.com', 'Saimon','NORMAL');

insert into caixa_eletronico (id, cep, cidade, data_abertura, data_encerramento, endereco, estado, saldo_disponivel, status) values (1,'79400-000', 'coxim', '2013-09-21', '2020-03-18', 'Centro 112', 'Mato Grosso do Sul', 10000, 'INDISPONIVEL');
insert into caixa_eletronico (id, cep, cidade, data_abertura, data_encerramento, endereco, estado, saldo_disponivel, status) values (2,'89551-000', 'silviolândia', '2011-02-11', '2022-03-21', 'Centro 111', 'Mato Grosso do Sul', 20000, 'INDISPONIVEL');
insert into caixa_eletronico (id, cep, cidade, data_abertura, data_encerramento, endereco, estado, saldo_disponivel, status) values (3,'30102-020', 'campo grande', '2003-09-22', null, 'Centro 12', 'Mato Grosso do Sul', 320000, 'DISPONIVEL');
insert into caixa_eletronico (id, cep, cidade, data_abertura, data_encerramento, endereco, estado, saldo_disponivel, status) values (4,'11102-020', 'ceilândia', '2000-09-22', null, 'Centro 12', 'Brasilia', 320000, 'DISPONIVEL');
insert into caixa_eletronico (id, cep, cidade, data_abertura, data_encerramento, endereco, estado, saldo_disponivel, status) values (5,'27102-020', 'sao paulo', '1999-10-12', null, 'Centro 1200', 'Sâo Paulo', 320000, 'DISPONIVEL');

insert into cartao (id, bandeira, cliente_id, data_abertura, data_encerramento, data_validade, numero, saldo, senha, status, tipo_cartao) values (1, 'VISA', 1, '2013-09-21', '2020-03-18', '2020-03-18', '123456789', 10000, '123', 'ATIVO', 'CREDITO');
