package module7;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //----------------------------------------------------------------------------------------------------------------
        //7.2

        List<User> users = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        users.add(new User(120, "Anton", "Antonenko", "Lviv", 2000));
        users.add(new User(121, "Sergey", "Sergienko", "Chernigiv", 3000));
        users.add(new User(122, "Ivan", "Ivanenko", "Poltava", 2500));
        users.add(new User(123, "Petr", "Petrenko", "Zhytomyr", 4000));
        users.add(new User(124, "Maria", "Adamenko", "Kyiv", 5000));
        users.add(new User(125, "Olga", "Gordienko", "Cherkasy", 3500));
        users.add(new User(126, "Irina", "Mostovenko", "Kharkiv", 4500));
        users.add(new User(127, "Yaroslav", "Goncharenko", "Lviv", 5500));
        users.add(new User(128, "Hanna", "Potapenko", "Dnipro", 1500));
        users.add(new User(129, "Inna", "Rudenko", "Rivne", 1000));

        orders.add(new Order(220, 300, Currency.UAH, "phone", "green", users.get(1)));
        orders.add(new Order(220, 300, Currency.UAH, "phone", "green", users.get(1)));
        orders.add(new Order(221, 1300, Currency.UAH, "wheel", "grey", users.get(3)));
        orders.add(new Order(222, 500, Currency.USD, "notebook", "white", users.get(5)));
        orders.add(new Order(223, 700, Currency.UAH, "photoframe", "yellow", users.get(0)));
        orders.add(new Order(224, 200, Currency.USD, "mouse", "blue", users.get(2)));
        orders.add(new Order(225, 4500, Currency.UAH, "freezer", "pink", users.get(6)));
        orders.add(new Order(226, 800, Currency.UAH, "mouse", "black", users.get(4)));
        orders.add(new Order(227, 300, Currency.USD, "headphones", "brown", users.get(9)));
        orders.add(new Order(228, 500, Currency.UAH, "mouse", "black", users.get(8)));
        orders.add(new Order(229, 2300, Currency.UAH, "router", "red", users.get(7)));

        System.out.println(users);
        System.out.println(orders);

        orders.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });

        System.out.println(orders);

        orders.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int res = o1.getPrice() - o2.getPrice();
                if (res == 0) {
                    return o2.getUser().getCity().compareTo(o1.getUser().getCity());
                } else {
                    return res;
                }
            }
        });

        System.out.println(orders);

        orders.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int res = o1.getItemName().compareTo(o2.getItemName());
                if (res == 0) {
                    int res1 = o2.getShopIdentificator().compareTo(o1.getShopIdentificator());
                    if (res1 == 0) {
                        return o1.getUser().getCity().compareTo(o2.getUser().getCity());
                    } else {
                        return o2.getUser().getCity().compareTo(o1.getUser().getCity());
                    }
                } else {
                    return res;
                }
            }
        });

        System.out.println(orders);

        Set<Order> uniqOrdersSet = new HashSet<>();
        uniqOrdersSet.addAll(orders);
        List<Order> uniqOrders = new ArrayList<>();
        uniqOrders.addAll(uniqOrdersSet);
        System.out.println(uniqOrders);


        List<Order> priceAbove1500 = new ArrayList<>();
        priceAbove1500.addAll(orders);
        Iterator<Order> iterator = priceAbove1500.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPrice() < 1500) iterator.remove();
        }
        System.out.println(priceAbove1500);


        List<Order> ordersInUSD = new ArrayList<>();
        ordersInUSD.addAll(orders);
        Iterator<Order> iterator1 = ordersInUSD.iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().getCurrency() == Currency.UAH) iterator1.remove();
        }
        System.out.println(ordersInUSD);


        List<Order> ordersInUAH = new ArrayList<>();
        ordersInUAH.addAll(orders);
        Iterator<Order> iterator2 = ordersInUAH.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().getCurrency() == Currency.USD) iterator2.remove();
        }
        System.out.println(ordersInUAH);


        Set<String> uniqCity = new TreeSet<>();
        for (User u : users) {
            uniqCity.add(u.getCity());
        }
        System.out.println(uniqCity);
        List<String> uniqCityList = new ArrayList<>();
        uniqCityList.addAll(uniqCity);
        List<Order> city = new ArrayList<>();
        for (int i = 0; i < uniqCity.size(); i++) {
            List<Order> temp = new ArrayList<>();
            for (Order order : orders) {
                if (uniqCityList.get(i) == order.getUser().getCity())
                    temp.add(order);
            }
            city.addAll(temp);
        }
        System.out.println(city);


//----------------------------------------------------------------------------------------------------------------
        //7.3

        Set<User> usersSet = new TreeSet<>();
        Set<Order> ordersSet = new TreeSet<>();

        usersSet.add(new User(120, "Anton", "Antonenko", "Lviv", 2000));
        usersSet.add(new User(121, "Sergey", "Sergienko", "Chernigiv", 3000));
        usersSet.add(new User(122, "Ivan", "Ivanenko", "Poltava", 2500));
        usersSet.add(new User(123, "Petr", "Petrenko", "Zhytomyr", 4000));
        usersSet.add(new User(124, "Maria", "Adamenko", "Kyiv", 5000));
        usersSet.add(new User(125, "Olga", "Gordienko", "Cherkasy", 3500));
        usersSet.add(new User(126, "Irina", "Mostovenko", "Kharkiv", 4500));
        usersSet.add(new User(127, "Yaroslav", "Goncharenko", "Lviv", 5500));
        usersSet.add(new User(128, "Hanna", "Potapenko", "Dnipro", 1500));
        usersSet.add(new User(129, "Inna", "Rudenko", "Rivne", 1000));

        ordersSet.add(new Order(220, 300, Currency.UAH, "phone", "green", users.get(1)));
        ordersSet.add(new Order(220, 300, Currency.UAH, "phone", "green", users.get(1)));
        ordersSet.add(new Order(221, 1300, Currency.UAH, "wheel", "grey", users.get(3)));
        ordersSet.add(new Order(222, 500, Currency.USD, "notebook", "white", users.get(5)));
        ordersSet.add(new Order(223, 700, Currency.UAH, "photoframe", "yellow", users.get(0)));
        ordersSet.add(new Order(224, 200, Currency.USD, "mouse", "blue", users.get(2)));
        ordersSet.add(new Order(225, 4500, Currency.UAH, "freezer", "pink", users.get(6)));
        ordersSet.add(new Order(226, 800, Currency.UAH, "mouse", "black", users.get(4)));
        ordersSet.add(new Order(227, 300, Currency.USD, "headphones", "brown", users.get(9)));
        ordersSet.add(new Order(228, 500, Currency.UAH, "mouse", "black", users.get(8)));
        ordersSet.add(new Order(229, 2300, Currency.UAH, "router", "red", users.get(7)));

        System.out.println(usersSet);
        System.out.println(ordersSet);
        System.out.println(ordersSet.size());

        String lastNameChek = "Rudenko";
        boolean res = false;
        for (Order order : ordersSet) {
            if (order.getUser().getLastName().equals(lastNameChek)) {
                res = true;
            }
        }
        System.out.println(res);


        System.out.println(ordersSet.iterator().next());


        Set<Order> delateUSDOrders = new TreeSet<>();
        delateUSDOrders.addAll(ordersSet);
        Iterator<Order> iterator3 = delateUSDOrders.iterator();
        while (iterator3.hasNext()) {
            if (iterator3.next().getCurrency() == Currency.USD) iterator3.remove();
        }
        System.out.println(delateUSDOrders);

        //----------------------------------------------------------------------------------------------------------------
        //7.5

        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<Integer> integerLinked = new LinkedList<>();
        List<String> stringLinked = new LinkedList<>();

        Random random = new Random();
        int count = 10000;

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            integers.add(new Integer(random.nextInt()));
        }
        long finish = System.currentTimeMillis();
        System.out.println(count + " integers added in ArrayList in " + (finish - start) + " ms");

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            integers.set(i, new Integer(random.nextInt()));
        }
        long finish1 = System.currentTimeMillis();
        System.out.println(count + " integers seted in ArrayList in " + (finish1 - start1) + " ms");

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            integers.get(i);
        }
        long finish2 = System.currentTimeMillis();
        System.out.println(count + " integers geted from ArrayList in " + (finish2 - start2) + " ms");

        int k = count;
        long start3 = System.currentTimeMillis();
        while (k > 0) {
            k--;
            integers.remove(k);
        }
        long finish3 = System.currentTimeMillis();
        System.out.println(count + " integers removed from ArrayList in " + (finish3 - start3) + " ms");

        long start01 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            strings.add(new Integer(random.nextInt()).toString());
        }
        long finish01 = System.currentTimeMillis();
        System.out.println(count + " strings added in ArrayList in " + (finish01 - start01) + " ms");

        long start11 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            strings.set(i, new Integer(random.nextInt()).toString());
        }
        long finish11 = System.currentTimeMillis();
        System.out.println(count + " strings seted in ArrayList in " + (finish11 - start11) + " ms");

        long start21 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            strings.get(i);
        }
        long finish21 = System.currentTimeMillis();
        System.out.println(count + " strings geted from ArrayList in " + (finish21 - start21) + " ms");

        int j = count;
        long start31 = System.currentTimeMillis();
        while (j > 0) {
            j--;
            strings.remove(j);
        }
        long finish31 = System.currentTimeMillis();
        System.out.println(count + " strings removed from ArrayList in " + (finish31 - start31) + " ms");

        long start011 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            integerLinked.add(new Integer(random.nextInt()));
        }
        long finish011 = System.currentTimeMillis();
        System.out.println(count + " Linkedintegers added in ArrayList in " + (finish011 - start011) + " ms");

        long start110 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            integerLinked.set(i, new Integer(random.nextInt()));
        }
        long finish110 = System.currentTimeMillis();
        System.out.println(count + " Linkedintegers seted in ArrayList in " + (finish110 - start110) + " ms");

        long start210 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            integerLinked.get(i);
        }
        long finish210 = System.currentTimeMillis();
        System.out.println(count + " Linkedintegers geted from ArrayList in " + (finish210 - start210) + " ms");

        int k1 = count;
        long start310 = System.currentTimeMillis();
        while (k1 > 0) {
            k1--;
            integerLinked.remove(k1);
        }
        long finish310 = System.currentTimeMillis();
        System.out.println(count + " Linkedintegers removed from ArrayList in " + (finish310 - start310) + " ms");

        long start010 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringLinked.add(new Integer(random.nextInt()).toString());
        }
        long finish010 = System.currentTimeMillis();
        System.out.println(count + " Linkedstrings added in ArrayList in " + (finish010 - start010) + " ms");

        long start111 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringLinked.set(i, new Integer(random.nextInt()).toString());
        }
        long finish111 = System.currentTimeMillis();
        System.out.println(count + " Linkedstrings seted in ArrayList in " + (finish111 - start111) + " ms");

        long start211 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringLinked.get(i);
        }
        long finish211 = System.currentTimeMillis();
        System.out.println(count + " Linkedstrings geted from ArrayList in " + (finish211 - start211) + " ms");

        int j1 = count;
        long start311 = System.currentTimeMillis();
        while (j1 > 0) {
            j1--;
            stringLinked.remove(j1);
        }
        long finish311 = System.currentTimeMillis();
        System.out.println(count + " Linkedstrings removed from ArrayList in " + (finish311 - start311) + " ms");


    }
}
