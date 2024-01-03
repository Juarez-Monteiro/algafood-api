insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante Tailandes', 7.5, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante Indiano', 8, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante Indiano2', 8.5, 2);

insert into estado (id, nome) values (1, 'Pernambuco');
insert into estado (id, nome) values (2, 'Paraíba');
insert into estado (id, nome) values (3, 'Rio Garnde do Norte');

insert into cidade (nome, estado_id) values ('Garanhuns', 1);
insert into cidade (nome, estado_id) values ('João Pessoa', 2);
insert into cidade (nome, estado_id) values ('Natal', 3);

insert into forma_pagamento (descricao) value ('Cartão');
insert into forma_pagamento (descricao) value ('Dinheiro');
insert into forma_pagamento (descricao) value ('Pix');

insert into permissao (nome, descricao) values ('Cliente', 'Cliente poderar realizar os pedidos');
insert into permissao (nome, descricao) values ('Gerencial', 'Terar acesso a todos os serviços');