INSERT INTO pedido(nome, cpf, data, status, valor_total) values('Jon Snow', '89893542345', '2025-11-25', 'CRIADO', 790.0);
INSERT INTO pedido(nome, cpf, data, status, valor_total) values('Pelé', '43213423421', '2025-11-25','CRIADO', 3599.0);

INSERT INTO tb_item_pedido(quantidade, descricao, preco_unitario, pedido_id) values(2, 'Mouse sem fio microsoft', 250, 1);
INSERT INTO tb_item_pedido(quantidade, descricao, preco_unitario, pedido_id) values(1, 'Teclado sem fio microsoft', 290, 1);
INSERT INTO tb_item_pedido(quantidade, descricao, preco_unitario, pedido_id) values(1, 'Smart tv LG LED', 3599.0, 2);