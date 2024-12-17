USE dsw;

INSERT INTO Coordenada (latitud, longitud, id_coordenadas) VALUES (12, 13, 1), (10, 9, 2), (14, 16, 3), (17, 18, 4);

INSERT INTO Cliente (id_cliente, id_coordenadas, CUIT, direccion, email, activo) VALUES (1, 1, '123123123', 'Lavaisse', 'hola@xdlol.com', true), (2, 3, '456456456', 'Chacabuco', 'adios@xdnolol.com', true);

INSERT INTO Vendedor (id_vendedor, id_coordenadas, DNI, apellido, nombre, direccion, activo) VALUES (1, 2, '12345345', 'Ledesma', 'Orlando', 'Antartida', true), (2, 4, '11222333', 'Jorge', 'Sanabria', 'Turkmenistan', true);

INSERT INTO Categoria (id_categoria, descripcion, tipo) VALUES (1, 'Carne', 'PLATO'), (2, 'Vino', 'BEBIDA');

INSERT INTO Item_menu (id_item_menu, id_categoria, nombre, precio, descripcion, id_vendedor, aptoVegano, disponible) VALUES (1, 1, 'Filete', 200, 'Fileton', 1, false, true)
INSERT INTO Item_menu (id_item_menu, id_categoria, nombre, precio, descripcion, id_vendedor, aptoVegano, disponible) VALUES (2, 2, 'Vino Blanco', 1000, 'PARA PONERSE EN PEDO', 1, true, true);

INSERT INTO Bebida (id_item_menu, tamaño, graduacionAlcohol) VALUES (2, 2000, 0.5);

INSERT INTO Plato (id_item_menu, cant_calorias, aptoVegetariano, aptoCeliaco) VALUES (1, 30, false, false);

