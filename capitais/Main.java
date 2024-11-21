package capitais;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Lista de cidades
        List<Cidade> cidades = Arrays.asList(
                new Cidade("GO", "Anápolis", false),
                new Cidade("GO", "Goiânia", true),
                new Cidade("SP", "Ribeirão Preto", false),
                new Cidade("SP", "Campinas", false),
                new Cidade("MG", "Belo Horizonte", true),
                new Cidade("MG", "Uberlândia", false),
                new Cidade("MG", "Montes Claros", false),
                new Cidade("MG", "Unaí", false),
                new Cidade("TO", "Palmas", true),
                new Cidade("TO", "Araguarí", false),
                new Cidade("MT", "Cuiabá", true),
                new Cidade("MS", "Dourados", false),
                new Cidade("MS", "Campo Grande", true),
                new Cidade("MS", "Corumbá", false),
                new Cidade("MT", "Barra do Garças", false),
                new Cidade("MT", "Araguaiana", false),
                new Cidade("RO", "Porto Velho", true),
                new Cidade("RO", "Costa Marques", false)
        );

        // Estrutura 1: Agrupamento por UF
        Map<String, List<Cidade>> cidadesPorUf = new TreeMap<>();
        for (Cidade cidade : cidades) {
            cidadesPorUf.putIfAbsent(cidade.getUf(), new ArrayList<>());
            cidadesPorUf.get(cidade.getUf()).add(cidade);
        }

        System.out.println("Cidades agrupadas por UF (em ordem alfabética):");
        for (Map.Entry<String, List<Cidade>> entry : cidadesPorUf.entrySet()) {
            System.out.println("UF: " + entry.getKey());
            entry.getValue().sort(Comparator.naturalOrder());
            entry.getValue().forEach(System.out::println);
        }
        System.out.println();

        // Estrutura 2: Capitais primeiro, ordem alfabética
        System.out.println("Cidades (Capitais primeiro e em ordem alfabética):");
        cidades.stream()
                .sorted(Comparator.comparing(Cidade::isCapital).reversed()
                        .thenComparing(Cidade::getNome))
                .forEach(System.out::println);
        System.out.println();

        // Estrutura 3: Conjunto de cidades (Ordem alfabética decrescente)
        Set<Cidade> conjuntoCidades = new TreeSet<>(Comparator.comparing(Cidade::getNome).reversed());
        conjuntoCidades.addAll(cidades);

        System.out.println("Cidades em ordem alfabética decrescente:");
        conjuntoCidades.forEach(System.out::println);
    }
}
