package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ItemInitializer implements CommandLineRunner {

    private final ItemRepository ItemRepository;
	private com.example.demo.ItemRepository itemRepository;

    ItemInitializer(ItemRepository itemRepository) {
        this.ItemRepository = null;
		this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok")
                .forEach(item -> itemRepository.save(new Item(item)));

        itemRepository.findAll().forEach(System.out::println);
    }
}