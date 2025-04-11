package com.api.dealership.service;

import java.util.List;

import com.api.dealership.dto.CarDto;
import com.api.dealership.entity.Car;
import com.api.dealership.pages.PaginationData;

public interface ICarService {
    
    /**
     * Esse método retorna todos os carros disponíveis no sistema
     * @return Lista de carros do sistema 
    */
    public List<Car> getAll();

    /**
     * Esse método retorna parte dos carros cadastrados do sistema em uma página
     * @param page número da página desejada
     * @param size tamanho da página desejada
     * @return uma página de carros com tamanho determinado
     */
    public PaginationData<Car> getCars(Integer page, Integer size);

    /**
     *  Esse método busca um carro no banco de dados através de seu Id
     * e retorna ele este existindo
     * @param id o id do carro desejado
     * @return retorna um carro através do seu Id
     */
    public Car getCarById(Long id);

    /**
     * Esse método recebe os dados informados para criação do veiculo e salva o carro 
     * no banco de dados
     * @param carDto os dados que devem ser inseridos para criação do veículo
     * @return retorna o carro criado
     */
    public Car insertCar(CarDto carDto);

    /**
     * Esse método atualiza as informações de um veículo na base de dados através do id
     * passado via parâmetro e atualiza com as informações passadas via parâmetro
     * @param id do carro que deve ser atualizado
     * @param carDto informações novas para o carro
     * @return retorna o carro atualizado
     */
    public Car updateCar(Long id, CarDto carDto);

    /**
     * Esse método exclui um veiculo da base de dados, exclui aquele que contém o id passado
     * @param id do carro que deve ser deletado
     */
    public void deleteCar(Long id);
}
