import java.util.*;
import java.util.Map.Entry;

public class Portal 
{
    
    public static void display_info()
    {
        System.out.println("----------------WELCOME TO FLIPZON--------------------");
        System.out.println("1) Enter as Admin");
        System.out.println("2) Explore the Product Catalog");
        System.out.println("3) Show Available Deals");
        System.out.println("4) Enter as Customer");
        System.out.println("5) Exit the Application");

    }
    public static void main(String[] args)
    {
        ArrayList<ArrayList<ArrayList<String>>> cat_list = new ArrayList<ArrayList<ArrayList<String>>>();
        ArrayList<ArrayList<ArrayList<String>>> cat_list_product = new ArrayList<ArrayList<ArrayList<String>>>();
        ArrayList<ArrayList<String>> giveaway = new  ArrayList<ArrayList<String>>();
        Map<String,List<String>> disc_dict = new HashMap<String,List<String>>();
        Map<String,HashMap<String,String>> dict = new HashMap<String,HashMap<String,String>>();
        Map<String,HashMap<String,String>> dict_product = new HashMap<String,HashMap<String,String>>();
        Map<String,Integer> listedproducts = new HashMap();
        boolean is_logged = false;
        Map<String,List<String>> cust_id_pass = new HashMap<>();
        ArrayList<String> cart = new ArrayList<String>();
        ArrayList<ArrayList<String>> dealsincart = new ArrayList<ArrayList<String>>();
        boolean coupon_isav = false;
        int input_int = 1;
        Map<String, Float> ac_bal = new HashMap<>();
        // Float ac_bal = 0f;
        do
        {   
            display_info();
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            input_int = scn.nextInt();
                switch(input_int)
                {
                    case 1:
                    Admin Admin = new Admin();
                    Admin.Admin_1 ad_1 = Admin.new Admin_1();
                    Admin.Admin_2 ad_2 = Admin.new Admin_2();
                    Admin.auth_admin(ad_1.name,ad_2.name,ad_1.getPass(),ad_2.getPass());
                    int input = 1;
                do
                {  
                        Admin.admin_menu();
                        System.out.print("Enter your choice: ");
                        input = scn.nextInt();
                        switch(input)
                        {
                            case 1:
                                cat_list.add(Admin.add_category_product(cat_list,dict));
                                // System.out.println(cat_list);
                                for (int i = 0 ; i<cat_list.size(); i++)
                                {
                                    HashMap temp = new HashMap();
                                    temp.put("Category ID",((cat_list.get(i)).get(0)).get(0));
                                    listedproducts.put(((cat_list.get(i)).get(0)).get(0),1);
                                    for (int j=2; j<(cat_list.get(i)).size(); j++)
                                    {
                                        temp.put(((cat_list.get(i)).get(j)).get(0),((cat_list.get(i)).get(j)).get(1));
                                    }
                                    dict.put(((cat_list.get(i)).get(0).get(0)),temp);

                                    // for (int j = i+1; j<(cat_list.get(i)).size(); j++){
                                    //     temp.put(((cat_list.get(i)).get(j)).get(0),((cat_list.get(i)).get(j)).get(1));
                                    // }
                                    // dict.put(((cat_list.get(i)).get(i)).get(0),temp);
                                    for (int j=2; j<(cat_list.get(i)).size(); j++)
                                    {
                                        if (((cat_list.get(i)).get(j)).get(0).equals("Product ID")){
                                            dict_product.put(((cat_list.get(i)).get(j).get(1)),temp); 
                                            break;
                                        }
                                        
                                    }
                                    
                                }  
                                System.out.println(dict_product);
                                System.out.println(dict);
                                System.out.println(listedproducts);
                                break;
                            case 2:
                                System.out.print("Enter the category ID: ");
                                scn.nextLine();
                                String in = scn.nextLine();
                                int x = 0;
                                while(x==0){
                                    if (dict.containsKey(in)==true&&dict.size()!=0){
                                        dict.remove(in);
                                        System.out.println("Enter the category name: ");
                                        String in_str2 = scn.nextLine();
                                        System.out.println("Category removed");
                                        System.out.println(dict);
                                        x=1;
                                    }
                                    else if(dict.size()==0)
                                    {
                                        System.out.println("No category added!!");
                                        x=1;
                                    }
                                    else{
                                        System.out.println("Category already not present!!");
                                        System.out.print("Kindly re-enter:");
                                        in = scn.nextLine();
                                    
                                    }
                                        }
                                    for (Entry<String, HashMap<String, String>> entry : dict_product.entrySet()) {
                                        String key = entry.getKey();
                                        if(dict_product.get(key).get("Category ID").equals(in))
                                        {
                                            dict_product.remove(key);
                                        }
                                    }
                                
                            
                        
                                break;
                            case 3: 
                                cat_list_product.add(Admin.add_category_product(dict));
                                // System.out.println(cat_list);
                                int k0 = 2;
                                for (int i = 0 ; i<cat_list_product.size(); i++)
                                {
                                    HashMap temp = new HashMap();
                                    temp.put("Category ID",((cat_list.get(i)).get(0)).get(0));
                                    
                                    listedproducts.put(((cat_list.get(i)).get(0)).get(0),k0++);
                                    for (int j=1; j<(cat_list_product.get(i)).size(); j++)
                                    {
                                        temp.put(((cat_list_product.get(i)).get(j)).get(0),((cat_list_product.get(i)).get(j)).get(1));
                                        
                                    }
                                    for (int j=1; j<(cat_list_product.get(i)).size(); j++)
                                    {
                                        if (((cat_list_product.get(i)).get(j)).get(0).equals("Product ID")){
                                            dict_product.put(((cat_list_product.get(i)).get(j).get(1)),temp); 
                                            break;
                                        }
                                        
                                    }
                                    // for (int j = i+1; j<(cat_list.get(i)).size(); j++){
                                    //     temp.put(((cat_list.get(i)).get(j)).get(0),((cat_list.get(i)).get(j)).get(1));
                                    // }
                                    // dict.put(((cat_list.get(i)).get(i)).get(0),temp);
                                }  
                                System.out.println(dict_product);
                                System.out.println(cat_list_product);
                                System.out.println(listedproducts);
                                break;
                            case 4:
                                System.out.print("Enter Product ID: ");
                                scn.nextLine();
                                String p_id = scn.nextLine();
                                System.out.print("Enter Product name: ");
                                String p_name = scn.nextLine();
                                int b = 0;
                                Set key = dict_product.keySet();
                                // String str1 = c +".1";
                                // String str2 = c +".2";
                                // String str3 = c +".3";
                                // String str4 = c +".4";
                                // String str5 = c +".5";
                                // String str6 = c +".6";
                                // String str7 = c +".7";
                                // String str8 = c +".8";
                                // String str9 = c +".9";
                                int count = 0;
                                while(b==0)
                                {
                                    if(dict_product.containsKey(p_id))
                                    {
                                        
                                        String cat = dict_product.get(p_id).get("Category ID");
                                        System.out.println(cat);
                                        dict_product.remove(p_id);
                                        // for (Entry<String, HashMap<String, String>> entry : dict_product.entrySet()) {
                                        //     String key1 = entry.getKey();
                                        //     if (key1.contains(cat))
                                        //     {
                                                
                                        //     }
                                        //     if (count<2)
                                        //     {
                                        //         System.out.println("Category Empty!! Hence Deleted");
                                        //         dict.remove(cat);
                                        //     }
                                        //     // if(!dict_product.get(key1).get("Category ID").equals(cat))
                                        //     // {
                                        //     //     System.out.println("Category Empty!! Hence Deleted");
                                        //     //     dict.remove(cat);
                                        //     // }
                                        // }
                                        int st = listedproducts.get(cat);
                                        int num = Integer.valueOf(st);
                                        System.out.println(num);
                                        if(num<2) {
                                            dict.remove(cat);
                                            listedproducts.remove(cat);
                                            System.out.println("No more Products!! Category also emptied");
                                            System.out.println(listedproducts);
                                        } 
                                        else{
                                            num = num-1;
                                            listedproducts.put(cat,num);
                                            System.out.println(listedproducts);
                                        }                                       
                                    
                                        b=1; 
                                    }
                                    else
                                    {   
                                        System.out.println("Product ID doesn't exist!!");
                                        System.out.print("Kindly re-enter: ");
                                        p_id = scn.nextLine();
                                    }
                                    
                                    
                                }
                                System.out.println("Work Done!!");
                                System.out.println(count);
                                System.out.println(dict);
                                System.out.println(dict_product);
                                break;
                            
                            case 5: 
                                System.out.println("Kindly Enter the Product id: ");
                                scn.nextLine();
                                String ip = scn.nextLine();
                                Set key1 = dict_product.keySet();
                                int k = 0;
                                while(k==0)
                                {
                                    if(key1.contains(ip))
                                    {
                                        k=1; 
                                    }
                                    else
                                    {   
                                        System.out.println("Product ID doesn't exist!!");
                                        System.out.print("Kindly re-enter: ");
                                        ip = scn.nextLine();
                                    }
                                    
                                    
                                } 
                                System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms)");   
                                String is = scn.nextLine();
                                List<String> my = new ArrayList<String>(Arrays.asList(is.split(" ")));
                                disc_dict.put(ip,my);
                                System.out.println("Discount added!!");
                                System.out.println(disc_dict);
                                System.out.println(my);
                                my.clear();
                                System.out.println(my);
                                break;
                            case 6:
                                System.out.print("Enter First Product ID: ");
                                scn.nextLine();
                                String one = scn.nextLine();
                                System.out.print("Enter Second Product ID: ");
                                String two = scn.nextLine();
                                // System.out.println(dict_product.get(one).get("Price"));
                                int a = 0;
                                while(a==0)
                                {
                                    if ((dict_product.containsKey(one) && dict_product.containsKey(two) && !one.equals(two)))
                                    {   String price1 = dict_product.get(one).get("Price");
                                        String price2 = dict_product.get(two).get("Price");
                                        Float og_price = Float.valueOf(price1) + Float.valueOf(price2);
                                        System.out.println("Enter the combined price(should be less than their original combined price in the Order ELITE PRIME NORMAL): ");
                                        String lst = scn.nextLine();
                                        
                                        List<String> llst = new ArrayList<String>(Arrays.asList(lst.split(" ")));
                                        int q = 0;
                                        while(q==0){
                                            if(Float.valueOf(llst.get(0))<og_price && Float.valueOf(llst.get(1))<og_price && Float.valueOf(llst.get(2))<og_price)
                                            {
                                                System.out.println("Deal Added!!");
                                                q=1;
                                            }
                                            else
                                            {
                                                System.out.println("Prices/Price is more than original price, Kindly re-enter: ");
                                                lst = scn.nextLine();
                                            }
                                            
                                        }
                                        ArrayList<String> tem = new ArrayList<String>();
                                        tem.add(one);
                                        tem.add(two);
                                        tem.add(String.valueOf(og_price));
                                        tem.add(String.valueOf(llst.get(0)));
                                        tem.add(String.valueOf(llst.get(1)));
                                        tem.add(String.valueOf(llst.get(2)));

                                        giveaway.add(tem);
                                        System.out.println(giveaway);
                                        System.out.println(giveaway.size());
                                        a=1;
                                    }  
                                    else
                                    {   
                                        System.out.println("Error! Kindly re-enter");
                                        System.out.print("Enter First Product ID: ");
                                        one = scn.nextLine();
                                        System.out.print("Enter Second Product ID: ");
                                        two = scn.nextLine();
                                    }
                                    
                                
                                }
                                break;
                            case 7:
                                break;    
                            


                        }
                    }while(input>0 && input!=7);
                    break;
                    case 2:
                        System.out.println("Available Products: ");
                        for(Map.Entry disp: dict_product.entrySet()){  

                            for (Map.Entry disp0: ((Map<String, List<String>>) disp.getValue()).entrySet())
                            {
                                System.out.println(disp0.getKey()+ ": "+disp0.getValue());
                            }
                            
                            }
                            System.out.println();
                            System.out.println();
                            System.out.println();
                        break;
                    case 3:
                        System.out.println("Sorry No deals Right now!!");
                        break;
                    case 4:
                        int input0 = 1;
                        while(input0>0 && input0!=3)
                        {   
                            Customer.log_choice();
                            System.out.print("Enter choice: ");
                            input0 = scn.nextInt();
                            switch(input0)
                            {
                                case 1:
                                    Customer.register(cust_id_pass);
                                    break;
                                case 2:
                                    System.out.print("Enter email: ");
                                    scn.nextLine();
                                    String email = scn.nextLine();
                                    System.out.print("Enter Password: ");
                                    String pas = scn.nextLine();
                                    if(Customer.login(cust_id_pass, email, pas))
                                    {
                                        System.out.println("p");
                                        ac_bal.put(email,1000f);
                                        int choice = 1;
                                        while(choice>0 && choice!=12)
                                        {
                                            Customer.cust_menu();
                                            System.out.print("Enter choice: ");
                                            choice = scn.nextInt();
                                            switch(choice)
                                            {   case 1:
                                                System.out.println("Available Products: ");
                                                for(Map.Entry disp: dict_product.entrySet()){  
            
                                                    for (Map.Entry disp0: ((Map<String, List<String>>) disp.getValue()).entrySet())
                                                    {
                                                        System.out.println(disp0.getKey()+ ": "+disp0.getValue());
                                                    }
                                                    
                                                    }
                                                    System.out.println();
                                                    System.out.println();
                                                    System.out.println();
                                                break; 
                                                case 2:
                                                int size = giveaway.size();
                                                int i = 0;
                                                while(i<size){
                                                    String a = (giveaway.get(i)).get(0);
                                                    String b = (giveaway.get(i)).get(1);
                                                    for (Map.Entry disp1: (dict_product.get(a)).entrySet())
                                                    {
                                                        System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                    }
                                                    System.out.println("--------------------------------------------");
                                                    System.out.println("--------------------------------------------");
                                                    for (Map.Entry disp1: (dict_product.get(b)).entrySet())
                                                    {
                                                        System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                    }
                                                    if(cust_id_pass.get(email).get(2).equals("ELITE"))
                                                    {
                                                        System.out.println("Available for a combined Price of: "+(giveaway.get(i)).get(3));
                                                    }
                                                    else if(cust_id_pass.get(email).get(2).equals("PRIME"))
                                                    {
                                                        System.out.println("Available for a combined Price of: "+(giveaway.get(i)).get(4));
                                                    }
                                                    else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                    {
                                                        System.out.println("Available for a combined Price of: "+(giveaway.get(i)).get(5));
                                                    }
                                                    
                                                    i=i+1;
                                                    
                                                    
                                                }
                                                break;
                                                // for(Map.Entry disp: dict_product.entrySet()){  
            
                                                //     for (Map.Entry disp0: ((Map<String, List<String>>) disp.getValue()).entrySet())
                                                //     {
                                                //         System.out.println(disp0.getKey()+ " "+disp0.getValue());
                                                //     }
                                                //     System.out.println();
                                                //     System.out.println();
                                                //     System.out.println();
                                                //     }
                                                // for(int i = 0; i<giveaway.size(); i++)
                                                // {
                                                //     String a = (giveaway.get(i)).get(0);
                                                //     String b = (giveaway.get(i)).get(1);
                                                //     System.out.println(a+b);
                                                //     for (Map.Entry disp1: (dict_product.get(a)).entrySet())
                                                //     {
                                                //         System.out.println(disp1.getKey()+ " "+disp1.getValue());
                                                //     }
                                                    
                                                //     for (Map.Entry disp1: (dict_product.get(b)).entrySet())
                                                //     {
                                                //         System.out.println(disp1.getKey()+ " "+disp1.getValue());
                                                //     }
                                                //     System.out.println("Available for a combined Price of: "+(giveaway.get(i)).get(4));
                                                    
                                                // }
                                                // System.out.println();
                                                // System.out.println();
                                                case 3:
                                                    System.out.print("Enter Product ID: ");
                                                    scn.nextLine();
                                                    String in = scn.nextLine();
                                                    System.out.println("Enter Qty: ");
                                                    int en1 = scn.nextInt();
                                                    int qty = Integer.valueOf(dict_product.get(in).get("Qty"));
                                                    int ele = 0;
                                                    while(ele==0)
                                                    {
                                                        if(dict_product.containsKey(in) && en1<=qty)
                                                        {
                                                            cart.add(in);
                                                            cart.add(String.valueOf(en1));
                                                            // qty = qty-en1;
                                                            // System.out.print(qty);
                                                            // String q = String.valueOf(qty);
                                                            // // (dict_product.get(in)).put("Qty",String.valueOf(qty));
                                                            // // dict_product.get(in).computeIfPresent("Qty", (key, oldValue) -> String.valueOf(Integer.valueOf(oldValue)-en1));
                                                            // System.out.println(dict_product);
                                                            // dict_product.get(in).put("Qty",q);
                                                            // System.out.println(dict_product);
                                                            System.out.println(dict_product);
                                                            System.out.println("Product Added to cart!!");
                                                            ele = 1;
                                                        }
                                                        else if(en1>qty){
                                                            System.out.println("Quantity entered is more than available");
                                                            System.out.print("Re-enter Quantity: ");
                                                            en1 = scn.nextInt();
                                                            
                                                        }
                                                        else if(qty == 0)
                                                        {
                                                            System.out.println("Product out of stock, choose a new product!!");
                                                            ele = 1;
                                                        }
                                                        else{
                                                            System.out.println("Product not Found!!");
                                                        }
                                                    }    
                                                    break;
                                                case 4:
                                                    System.out.println("Available combos...");  
                                                    System.out.println();  
                                                    int size0 = giveaway.size();
                                                    int i0 = 0;
                                                    while(i0<size0){
                                                        String a = (giveaway.get(i0)).get(0);
                                                        String b = (giveaway.get(i0)).get(1);
                                                        for (Map.Entry disp1: (dict_product.get(a)).entrySet())
                                                        {
                                                            System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                        }
                                                        System.out.println("--------------------------------------------");
                                                        System.out.println("--------------------------------------------");
                                                        for (Map.Entry disp1: (dict_product.get(b)).entrySet())
                                                        {
                                                            System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                        }
                                                        if(cust_id_pass.get(email).get(2).equals("ELITE"))
                                                        {
                                                            System.out.println("Available for a combined Price of: "+(giveaway.get(i0)).get(3));
                                                        }
                                                        else if(cust_id_pass.get(email).get(2).equals("PRIME"))
                                                        {
                                                            System.out.println("Available for a combined Price of: "+(giveaway.get(i0)).get(4));
                                                        }
                                                        else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                        {
                                                            System.out.println("Available for a combined Price of: "+(giveaway.get(i0)).get(5));
                                                        }
                                                        
                                                        i0=i0+1;
                                                        
                                                
                                                    }
                                                    System.out.println();
                                                    System.out.println();
                                                    System.out.println("For Adding to cart");
                                                    System.out.println("Enter First Product ID: ");
                                                    scn.nextLine();
                                                    String f1 = scn.nextLine();
                                                    System.out.println("Enter Second Product ID: ");
                                                    String f2 = scn.nextLine();
                                                    for(int i1 = 0; i1<giveaway.size(); i1++)
                                                    {
                                                        if((giveaway.get(i1).get(0).equals(f1))&&(giveaway.get(i1).get(1).equals(f2)))
                                                        {
                                                            dealsincart.add(giveaway.get(i1));
                                                            System.out.println(dealsincart);
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Wrong ID entered");
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                Customer.Elite elc = new Customer.Elite();
                                                Customer.Prime pc = new Customer.Prime();
                                                
                                                System.out.println("Available Coupons!!");
                                                // Customer.Elite e = new Customer.Elite();
                                                // Customer.Prime p = new Customer.Prime();
                                                if (cust_id_pass.get(email).get(2).equals("PRIME"))
                                                {
                                                    System.out.println("Code 1"+": "+pc.c1+"%");
                                                    System.out.println("Code 2"+": "+pc.c2+"%");
                                                    System.out.println("Coupon of highest value will be auto applied during checkout!!");
                                                }
                                               
                                                else if (cust_id_pass.get(email).get(2).equals("ELITE"))
                                                {
                                                    System.out.println("code1"+": "+elc.c1+"%");
                                                    System.out.println("code2"+": "+elc.c2+"%");
                                                    System.out.println("code3"+": "+elc.c3+"%");
                                                    System.out.println("code4"+": "+elc.c4+"%");
                                                    System.out.println("Coupon of highest value will be auto applied during checkout!!");
                                                }
                                        
                                                else if (cust_id_pass.get(email).get(2).equals("NORMAL")){
                                                    System.out.println("No coupons Availabe!!");
                                                }
                                               
                                                    break;
                                                case 6:
                                                    System.out.print("Current Balance: Rs. "+ac_bal.get(email)+"/-");
                                                    System.out.println();
                                                    break;
                                                case 7:
                                                    
                                                    System.out.println("Products in Cart");
                                                    System.out.println("----------------------");
                                                    int size1 = cart.size();
                                                    int k = 0;
                                                    if(cart.size()!=0)
                                                    {
                                                        for(int x=0; x<cart.size();x++)
                                                        {   
                                                            if(x%2==0)
                                                            {
                                                                for (Map.Entry disp1: (dict_product.get(cart.get(x))).entrySet())
                                                                    {   
                                                                        if(disp1.getKey().equals("Qty"))
                                                                        {
                                                                            System.out.println("Qty Requested: "+cart.get(x+1));
                                                                        }
                                                                        System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                                    }  
                                                            System.out.println("---------------------------------");
                                                            }
                                                                    
                                                            // while(k==0)
                                                            // {
                                                            //     if(cart.get(x).equals(pd))
                                                            //     {
                                                            //         for (Map.Entry disp1: (dict_product.get(cart.get(i))).entrySet())
                                                            //         {
                                                            //             System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                            //         }
                                                            //         k=1;
                                                            //     }
                                                            //     else{
                                                            //             System.out.println("Product Id not presnt");
                                                            //             System.out.print("Kindly re-enter: ");
                                                            //             pd = scn.nextLine();
                                                            //         }    }
                                                        }
                                                       
                                                    } 
                                                    if(dealsincart.size()!=0)
                                                    {
                                                        
                                                        int size5 = giveaway.size();
                                                        int i4 = 0;
                                                        while(i4<size5){
                                                            String a = (giveaway.get(i4)).get(0);
                                                            String b = (giveaway.get(i4)).get(1);
                                                            for (Map.Entry disp1: (dict_product.get(a)).entrySet())
                                                            {
                                                                System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                            }
                                                            System.out.println("--------------------------------------------");
                                                            System.out.println("--------------------------------------------");
                                                            for (Map.Entry disp1: (dict_product.get(b)).entrySet())
                                                            {
                                                                System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                            }
                                                            if(cust_id_pass.get(email).get(2).equals("ELITE"))
                                                            {
                                                                System.out.println("Available for a combined Price of: "+(giveaway.get(i4)).get(3));
                                                            }
                                                            else if(cust_id_pass.get(email).get(2).equals("PRIME"))
                                                            {
                                                                System.out.println("Available for a combined Price of: "+(giveaway.get(i4)).get(4));
                                                            }
                                                            else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                            {
                                                                System.out.println("Available for a combined Price of: "+(giveaway.get(i4)).get(5));
                                                            }
                                                            
                                                            i4=i4+1;
                                                            
                                                            
                                                        }
                                                    }   
                                                    else{
                                                        System.out.println("Cart empty!!");
                                                    }

                                                    break;
                                                case 8:
                                                    if(cart.size()>0)
                                                    {
                                                        cart.clear();
                                                        System.out.println("Cart emptied!!");
                                                    }
                                                    else if(cart.size()==0){
                                                        System.out.println("Cart Already Empty!!");
                                                    }
                                                    dealsincart.clear();
                                                    break;
                                            
                                                // case 9:
                                                // System.out.println("Products in Cart");
                                                // System.out.println("----------------------");
                                                // // if(cart.size()!=0)
                                                // {
                                                //     // for(int x=0; x<cart.size();x++)
                                                //     // { 
                                                //     //     for (Map.Entry disp1: (dict_product.get(cart.get(x))).entrySet())
                                                //     //             {
                                                //     //                 System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                //     //             }  
                                                //     //     System.out.println("---------------------------------");        
                                                //     //     // while(k==0)
                                                //     //     // {
                                                //     //     //     if(cart.get(x).equals(pd))
                                                //     //     //     {
                                                //     //     //         for (Map.Entry disp1: (dict_product.get(cart.get(i))).entrySet())
                                                //     //     //         {
                                                //     //     //             System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                //     //     //         }
                                                //     //     //         k=1;
                                                //     //     //     }
                                                //     //     //     else{
                                                //     //     //             System.out.println("Product Id not presnt");
                                                //     //     //             System.out.print("Kindly re-enter: ");
                                                //     //     //             pd = scn.nextLine();
                                                //     //     //         }    }
                                                //     // }
                                                   
                                                // } 
                                                // // if(dealsincart.size()!=0)
                                                // {
                                                    
                                                //     // int size5 = giveaway.size();
                                                //     // int i4 = 0;
                                                //     // while(i4<size5){
                                                //     //     String a = (giveaway.get(i4)).get(0);
                                                //     //     String b = (giveaway.get(i4)).get(1);
                                                //     //     for (Map.Entry disp1: (dict_product.get(a)).entrySet())
                                                //     //     {
                                                //     //         System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                //     //     }
                                                //     //     System.out.println("--------------------------------------------");
                                                //     //     System.out.println("--------------------------------------------");
                                                //     //     for (Map.Entry disp1: (dict_product.get(b)).entrySet())
                                                //     //     {
                                                //     //         System.out.println(disp1.getKey()+ ": "+disp1.getValue());
                                                //     //     }
                                                //     //     System.out.println("Available for a combined Price of: "+(giveaway.get(i4)).get(3));
                                                //     //     i4=i4+1;
                                                        
                                                        
                                                //     // }
                                                // }
                                                
                       
                                                //     System.out.print("Final Price: ");
                                                //     float price = 0f;
                                                //     boolean tf = false;
                                                //     ArrayList pd = new ArrayList<>();
                                                //     for(int j=0;j<cart.size();j++)

                                                //     {   if(disc_dict.containsKey(cart.get(j)))
                                                //         {
                                                //             tf = true;
                                                //             pd.add(cart.get(j));
                                                //         }
                                                //         if(j%2==0)
                                                //         {   
                                                //             float te = Float.valueOf(dict.get(cart.get(j)).get("Price"));
                                                //             te = (te)*Float.valueOf(cart.get(j+1));
                                                //             price = price+te;
                                                //         }
                                                //         if(dealsincart.size()>1)
                                                //         {
                                                //             for(int z=0;z<dealsincart.size();z++)
                                                //             {
                                                //                 float get = Float.valueOf(dealsincart.get(z).get(3));
                                                //                 price = price+get;
                                                //             }
                                                //         }
                                                //         System.out.print("Price before Discounts: Rs. ");
                                                //         System.out.println(price+"/-");
                                                //         if (cust_id_pass.get(email).get(2).equals("PRIME"))
                                                //         {
                                                //             System.out.println("PRIME discount: 5%");
                                                //             price = (price-0.05f*(price));
                                                //             if(tf)
                                                //             {
                                                //                 for(int m = 0; m<pd.size(); m++)
                                                //                 {   
                                                //                     System.out.println(("Additional Discount: "+disc_dict.get(m).get(1)+"%"));
                                                //                     price = price-(Float.valueOf(disc_dict.get(m).get(1))*(price))/100;
                                                //                 }  
                                                //             }      
                                                //                     Customer.pc pcc = new Customer.pc();
                                                //                     if(price>5000 && pcc.c)
                                                //                     {
                                                //                         price = price-0.1f*(price);
                                                //                         System.out.println("Coupon of highest value auto applied!!");
                                                //                     }
                                                //                     else if (price>5000 && pcc.c==false)
                                                //                     {   
                                                //                         Customer.Prime pp = new Customer.Prime();
                                                //                         System.out.println("Congrats you have got new coupons: ");
                                                //                         System.out.println(pp.code1+": "+pp.discount1+"%");
                                                //                         System.out.println(pp.code2+": "+pp.discount2+"%");
                                                //                     }
                                                //                 int delivery = 100;
                                                //                 System.out.println("Delivery Charge: "+delivery+0.02f*(price));
                                                //                 price = price+100+0.02f*(price);
                                                                
                                                //                 if (price<ac_bal.get(email))
                                                //                 {
                                                                    
                                                //                     ac_bal.put(email,ac_bal.get(email)-price);
                                                //                     System.out.println("Final Price: Rs. "+price+"/-");
                                                //                     System.out.println("Checked Out Scuccessfully!!");
                                                //                     System.out.println("Delivery within 3-6 days");

                                                //                 }
                                                //                 else
                                                //                 {
                                                //                     System.out.println("Insufficient balance!!");
                                                //                 }
                                                            
                                                            

                                                //         }
                                                //         else if (cust_id_pass.get(email).get(2).equals("ELITE"))
                                                //         {
                                                //             System.out.println("ELITE discount: 10%");
                                                //             price = (price-0.1f*(price));
                                                //             if(tf)
                                                //             {
                                                //                 for(int m = 0; m<pd.size(); m++)
                                                //                 {   
                                                //                     System.out.println(("Additional Discount: "+disc_dict.get(m).get(0)+"%"));
                                                //                     price = price-(Float.valueOf(disc_dict.get(m).get(1))*(price))/100;
                                                //                 } 
                                                //             }       
                                                //                     Customer.elc pcc = new Customer.elc();
                                                //                     if(price>5000 && pcc.c)
                                                //                     {
                                                //                         price = price-0.14f*(price);
                                                //                         System.out.println("Coupon of highest value auto applied!!");
                                                //                     }
                                                //                     else if (price>5000 && pcc.c==false)
                                                //                     {   
                                                //                         Customer.Elite pp = new Customer.Elite();
                                                //                         System.out.println("Congrats you have got new coupons: ");
                                                //                         System.out.println(pp.code1+": "+pp.discount1+"%");
                                                //                         System.out.println(pp.code2+": "+pp.discount2+"%");
                                                //                         System.out.println(pp.code3+": "+pp.discount3+"%");
                                                //                         System.out.println(pp.code4+": "+pp.discount4+"%");

                                                //                     }
                                                //                 int delivery = 100;
                                                //                 System.out.println("Delivery Charge: "+delivery);
                                                //                 price = price+100;
                                                //                 if (price<ac_bal.get(email))
                                                //                 {
                                                //                     ac_bal.put(email,ac_bal.get(email)-price);
                                                //                     System.out.println("Final Price: Rs. "+price+"/-");
                                                //                     System.out.println("Checked Out Scuccessfully!!");
                                                //                     System.out.println("You got a free Surprise, will arrive with your order!!");
                                                //                     System.out.println("Delivery with 2 days");

                                                //                 }
                                                //                 else
                                                //                 {
                                                //                     System.out.println("Insufficient balance!!");
                                                //                 }
                                                            
                                                //         }
                                                //         else{
                                                //             if(tf)
                                                //             {
                                                //                 for(int m = 0; m<pd.size(); m++)
                                                //                 {   
                                                //                     System.out.println(("Additional Discount: "+disc_dict.get(m).get(2)+"%"));
                                                //                     price = price-(Float.valueOf(disc_dict.get(m).get(1))*(price))/100;
                                                //                 } 
                                                //             }       
                                                //                     // Customer.elc pcc = new Customer.elc();
                                                //                     // if(price>5000 && pcc.c)
                                                //                     // {
                                                //                     //     price = price-0.14f*(price);
                                                //                     //     System.out.println("Coupon of highest value auto applied!!");
                                                //                     // }
                                                //                     // else if (price>5000 && pcc.c==false)
                                                //                     // {   
                                                //                     //     Customer.Elite pp = new Customer.Elite();
                                                //                     //     System.out.println("Congrats you have got new coupons: ");
                                                //                     //     System.out.println(pp.code1+": "+pp.discount1+"%");
                                                //                     //     System.out.println(pp.code2+": "+pp.discount2+"%");
                                                //                     //     System.out.println(pp.code3+": "+pp.discount3+"%");
                                                //                     //     System.out.println(pp.code4+": "+pp.discount4+"%");

                                                //                     // }
                                                //                 int delivery = 100;
                                                //                 System.out.println("Delivery Charge: "+delivery+0.05f*(price));
                                                //                 price = price+100+0.05f*(price);
                                                //                 if (price<ac_bal.get(email))
                                                //                 {
                                                //                     ac_bal.put(email,ac_bal.get(email)-price);
                                                //                     System.out.println("Final Price: Rs. "+price+"/-");
                                                //                     System.out.println("Checked Out Scuccessfully!!");
                                                //                     System.out.println("Delivery with 7-10 days");

                                                //                 }
                                                //                 else
                                                //                 {
                                                //                     System.out.println("Insufficient balance!!");
                                                //                 }
                                                            
                                                //         }
                                                //     }
                                                  
                                                // if(dealsincart.size() == 0 && cart.size()==0){
                                                //     System.out.println("Cart empty!!");
                                                // }
                                                case 9:
                                                    Float Price = 0f;
                                                    Float Price_deal = 0f;
                                                    Float F = 0f;
                                                    if(cart.size()!=0)
                                                    {
                                                        for(int x=0; x<cart.size();x++)
                                                        {   
                                                            if(x%2==0)
                                                            {
                                                                Price = Price + Float.valueOf(dict_product.get(cart.get(x)).get("Price"))*Integer.valueOf(cart.get(x+1));
                                                                String qty1 = String.valueOf(Float.valueOf(dict_product.get(cart.get(x)).get("Qty")) - Integer.valueOf(cart.get(x+1)));
                                                                System.out.print(qty1);
                                                                
                                                                
                                                                // (dict_product.get(in)).put("Qty",String.valueOf(qty));
                                                                // dict_product.get(in).computeIfPresent("Qty", (key, oldValue) -> String.valueOf(Integer.valueOf(oldValue)-en1));
                                                                System.out.println(dict_product);
                                                                dict_product.get(cart.get(x)).put("Qty",qty1);
                                                                System.out.println(dict_product);
                                                                // if(disc_dict.containsKey(cart.get(x)))
                                                                // {
                                                                //     if(cust_id_pass.get(email).get(2).equals("ELITE"))
                                                                //     {
                                                                //         Price = Price-(Float.valueOf(disc_dict.get(cart.get(x)).get(0))/100)*Float.valueOf(dict_product.get(cart.get(x)).get("Price")) ;
                                                                        
                                                                //     }
                                                                //     else if(cust_id_pass.get(email).get(2).equals("PRIME"))
                                                                //     {
                                                                //         Price = Price - (Float.valueOf(disc_dict.get(cart.get(x)).get(1))/100)*Float.valueOf(dict_product.get(cart.get(x)).get("Price")) ;
                                                                        
                                                                //     }
                                                                //     else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                                //     {
                                                                //         Price = Price - (Float.valueOf(disc_dict.get(cart.get(x)).get(2))/100)*Float.valueOf(dict_product.get(cart.get(x)).get("Price"))  ;
                                                                        
                                                                //     }
                                                                // }
                                                            }
                                                        } 
                                                        if(cust_id_pass.get(email).get(2).equals("ELITE"))
                                                        {
                                                            Price = Price - (10/100)*Price;
                                                            
                                                        }
                                                        else if(cust_id_pass.get(email).get(2).equals("PRIME"))
                                                        {
                                                            Price = Price - (5/100)*Price;
                                                            
                                                        }
                                                        
                                                        System.out.println("Total Cart value(excluding combos): Rs. "+Price+"/-");  
                                                        
                                                    }
                                                    if(dealsincart.size()!=0)
                                                    {
                                                        for(int z = 0;z<dealsincart.size();z++)
                                                        {
                                                            if(cust_id_pass.get(email).get(2).equals("ELITE"))
                                                            {
                                                               
                                                                Price_deal = Price_deal+Float.valueOf((giveaway.get(z)).get(3));
                                                            }
                                                            else if(cust_id_pass.get(email).get(2).equals("PRIME"))
                                                            {
                                                                
                                                                Price_deal = Price_deal+Float.valueOf((giveaway.get(z)).get(4));
                                                            }
                                                            else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                            {
                                                                
                                                                Price_deal = Price_deal+Float.valueOf((giveaway.get(z)).get(5));
                                                            }
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("No deals Selected!!");
                                                    }
                                                        System.out.println("Final Deals value: Rs. "+Price_deal+"/-");  
                                                        System.out.println("Discounts not applicable on deals but applied on normal cart value");
                                                        F = Price_deal+Price;
                                                        System.out.println("Final Cart value: Rs. "+F+"/-");
                                                        if(cust_id_pass.get(email).get(2).equals("ELITE") && F>=5000)
                                                        {   
                                                            int min = 10;  
                                                            int max = 15;  
                                                            
                                                            int ran = (int)(Math.random()*(max-min+1)+min);
                                                            System.out.println("Coupon of highest Value Applied Automatically: "+ran);
                                                            F = F-(ran/100)*F ;
                                                            System.out.println("Delivery charge: Rs. 100/-");
                                                            F = F+100;
                                                        }
                                                        else if(cust_id_pass.get(email).get(2).equals("PRIME")&& F>=5000)
                                                        {
                                                            
                                                            int min = 7;  
                                                            int max = 14;  
                                                            
                                                            int ran = (int)(Math.random()*(max-min+1)+min);
                                                            System.out.println("Coupon of highest Value Applied Automatically: "+ran+"%");
                                                            F = F - (ran/100)*F ;
                                                            System.out.println("Delivery charge:"+100+(2/100)*F);
                                                            F = F+100+(2/100)*F;
                                                        }
                                                        // else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                        // {
                                                            
                                                        //     int min = 5;  
                                                        //     int max = 11;  
                                                            
                                                        //     int ran = (int)(Math.random()*(max-min+1)+min);
                                                        //     System.out.println("Coupon of highest Value Applied Automatically: "+ran);
                                                        //     F = (ran/100)*F + F;
                                                        //     System.out.println("Delivery charge:"+100+(5/100)*F);
                                                        //     F = F+100+(5/100)*F;
                                                        // }
                                                        // if(cust_id_pass.get(email).get(2).equals("ELITE") && F>=5000)
                                                        // {   
                                                           
                                                        //     System.out.println("Delivery charge: Rs. 100/-");
                                                        //     F = F+100;
                                                        // }
                                                        // else if(cust_id_pass.get(email).get(2).equals("PRIME")&& F>=5000)
                                                        // {
                                                            
                                                            
                                                        //     System.out.println("Delivery charge:"+100+(2/100)*F);
                                                        //     F = F+100+(2/100)*F;
                                                        // }
                                                        else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                        {
                                                            
                                                           
                                                            System.out.println("Delivery charge:"+100+(5/100)*F);
                                                            F = F+100+(5/100)*F;
                                                        }
                                                        
                                                        if(F<ac_bal.get(email))

                                                        {   
                                                            
                                                            System.out.println("Final Value: "+F);
                                                            System.out.println("TYPE 'YES' TO PAY OR PRESS ANY OTHER KEY TO CANCEL: ");
                                                            scn.nextLine();
                                                            String y = scn.nextLine();
                                                            if(y.equals("YES"))
                                                            {
                                                                ac_bal.put(email,ac_bal.get(email)-F);
                                                                System.out.println("Checked Out!!");
                                                                    if(cust_id_pass.get(email).get(2).equals("ELITE") && F>=5000)
                                                                    {   
                                                                    
                                                                        System.out.println("Delivery within 2 days");
                                                                    
                                                                    }
                                                                    else if(cust_id_pass.get(email).get(2).equals("PRIME")&& F>=5000)
                                                                    {
                                                                        
                                                                        
                                                                        System.out.println("Delivery within 3-6 days");
                                                                        
                                                                    }
                                                                    else if(cust_id_pass.get(email).get(2).equals("NORMAL"))
                                                                    {
                                                                        
                                                                    
                                                                        System.out.println("Delivery within 7-8 days");
                                                                        
                                                                    }
                                                            }
                                                            else{
                                                                System.out.println("Order Cancelled!");
                                                            }        
                                                                
                                                        }
                                                        else{
                                                            System.out.println("Insufficient Balance!! ");
                                                        }


                                                    
                                                    
                                                   break;
                                                
                                                case 10:
                                                    System.out.println("Current Status: "+cust_id_pass.get(email).get(2));  
                                                    System.out.print("Enter new Status: ");
                                                    scn.nextLine();
                                                    String en = scn.nextLine();
                                                    
                                                    if(ac_bal.get(email)<200 || ac_bal.get(email)<300){
                                                        System.out.println("Insufficient Balnce!!");
                                                    }
                                                    
                                                    if(cust_id_pass.get(email).get(2).equals("ELITE") && en.equals("ELITE"))
                                                    {
                                                        System.out.println("Cant upgrade from ELITE to ELITE");
                                                    }
                                                    else if(cust_id_pass.get(email).get(2).equals("PRIME") && en.equals("PRIME"))
                                                    {
                                                        System.out.println("Cant upgrade from PRIME to PRIME");
                                                    }
                                                    else if (cust_id_pass.get(email).get(2).equals("PRIME") && en.equals("NORMAL")){
                                                        System.out.println("Status can't be updated to NORMAL again!!");
                                                    }
                                                    else if (cust_id_pass.get(email).get(2).equals("ELITE") && en.equals("NORMAL"))
                                                    {
                                                        System.out.println("Status can't be updated to NORMAL again!!");
                                                    }
                                                    else if (cust_id_pass.get(email).get(2).equals("ELITE") && en.equals("PRIME"))
                                                    {
                                                        System.out.println("Status can't be updated to PRIME again!!");
                                                    }
                                                    else if (cust_id_pass.get(email).get(2).equals("NORMAL") && en.equals("NORMAL"))
                                                    {
                                                        System.out.println("Status can't be updated to NORMAL!!");
                                                    }
                                                    else if ((en.equals("ELITE")) && (ac_bal.get(email)>=300))
                                                    {
                                                        cust_id_pass.get(email).set(2,en);
                                                        System.out.println("Updated Status: "+cust_id_pass.get(email).get(2));
                                                        
                                                        ac_bal.put(email,ac_bal.get(email)-300);
                                                        
                                                    }
                                                    else if ((en.equals("PRIME")) && (ac_bal.get(email)>=200))
                                                    {
                                                        cust_id_pass.get(email).set(2,en);
                                                        System.out.println("Updated Status: "+cust_id_pass.get(email).get(2));
                                                        
                                                        ac_bal.put(email,ac_bal.get(email)-200);
                                                        
                                                    }
                                                    
                                                    
                                                break;    
                                                case 11:
                                                    System.out.print("Enter Amount: ");
                                                    Float am = scn.nextFloat();
                                                    
                                                    ac_bal.put(email,ac_bal.get(email)+am);
                                                    System.out.println("Updated Balance: Rs. "+ac_bal.get(email)+"/-");
                                                    break;
                                            }
                                        }

                                    }
                                    
                                    break;
                                case 3:
                                    break;    

                            }
                        }
                        



                    
                }
            
        }while(input_int>0 && input_int!=5);

        
    }
}

class Admin{
    abstract class Admin_id{
        String name;
        
    }
    class Admin_1 extends Admin_id{
        protected String name = "Kanishk Kukreja";
        private String pass = "2021393";
        public String getPass() {
            return pass;
        }
        
    }
    class Admin_2 extends Admin_id{
        protected String name = "1";
        private String pass = "1";
        public String getPass() {
            return pass;
        }
    }
    

    ArrayList<ArrayList<String>> add_category_product(ArrayList<ArrayList<ArrayList<String>>> cat_list,Map<String, HashMap<String, String>> dict){
        Scanner scn = new Scanner(System.in);
        int i = 1;
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        // ArrayList<String> temp1 = new ArrayList<String>();
        System.out.println("Add category ID:-");
        String cat_ID = scn.nextLine();
        // for(int x = 0; x<cat_list.size(); x++)
        
        if (dict.containsKey(cat_ID)==true)
        {
            
            while(dict.containsKey(cat_ID)==true)
                {System.out.println("Category ID already used, Add another!!");
                System.out.println("Add category ID:-");
                cat_ID = scn.nextLine();}
            
        }
        
        String[] temp1 = cat_ID.split(" ");
        ArrayList<String> temp2 =  new ArrayList<String>(Arrays.asList(temp1));
        list.add(temp2);
        System.out.println("Add name of the category:-");
        String cat_Name = scn.nextLine();
        String[] temp3 = cat_Name.split(" ");
        ArrayList<String> temp4 =  new ArrayList<String>(Arrays.asList(temp3));
        list.add(temp4);
        // temp1.add(cat_ID);
        // temp1.add(cat_Name);
        // list.add(temp1.get(0));
        System.out.println("Add a Product:-");
        while(i != 0){
            
            String input = scn.nextLine();
            if(input.contains("Price:"))
            {   
                StringBuilder builder = new StringBuilder(input);
                builder.delete(7,11);
                builder.delete(builder.length()-2,builder.length());
                input = builder.toString();
                String[] temp0 = input.split(": ");
                ArrayList<String> temp =  new ArrayList<String>(Arrays.asList(temp0));
                list.add(temp);
                System.out.println("Category Added!!");
                i = 0;
            }
            else{
                String[] temp0 = input.split(": ");
                ArrayList<String> temp =  new ArrayList<String>(Arrays.asList(temp0));
                list.add(temp);
            }

        }
        
        // System.out.println(list);
        // System.out.println((list.get(1)).get(1));
        return list;
    }
    ArrayList<ArrayList<String>> add_category_product(Map<String, HashMap<String, String>> dict){
        if(dict.size()>0)
        {
            Scanner scn = new Scanner(System.in);
            int i = 1;
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
            // ArrayList<String> temp1 = new ArrayList<String>();
            System.out.println("Add category ID:-");
            String cat_ID = scn.nextLine();
            
            
                while(dict.containsKey(cat_ID)!=true)
                    {System.out.println("Category ID not present!!");
                    System.out.println("Add other category ID:-");
                    cat_ID = scn.nextLine();}
                String[] temp1 = cat_ID.split("");
                ArrayList<String> temp2 =  new ArrayList<String>(Arrays.asList(temp1));
                list.add(temp2);
                // System.out.println("Add name of the category:-");
                // String cat_Name = scn.nextLine();
                // String[] temp3 = cat_Name.split(" ");
                // ArrayList<String> temp4 =  new ArrayList<String>(Arrays.asList(temp3));
                // list.add(temp4);
                // temp1.add(cat_ID);
                // temp1.add(cat_Name);
                // list.add(temp1.get(0));
                System.out.println("Add a Product:-");
                while(i != 0)
                {
                    
                    String input = scn.nextLine();
                    if(input.contains("Price:"))
                    {
                        StringBuilder builder = new StringBuilder(input);
                        builder.delete(7,11);
                        builder.delete(builder.length()-2,builder.length());
                        input = builder.toString();
                        String[] temp0 = input.split(": ");
                        ArrayList<String> temp =  new ArrayList<String>(Arrays.asList(temp0));
                        list.add(temp);
                        System.out.println("Product Added!!");
                        i = 0;
                    }
                    
                    else
                    {   
                        String[] temp0 = input.split(": ");
                        ArrayList<String> temp =  new ArrayList<String>(Arrays.asList(temp0));
                        list.add(temp);
                    }
                }
                
                
                    // System.out.println(list);
                    // System.out.println((list.get(1)).get(1));
                
                    
                    // while((((cat_list.get(x)).get(x)).get(0)).equals(cat_ID))
                    //     {System.out.println("Category ID already used, Add another!!");
                    //     System.out.println("Add category ID:-");
            
                
                    //     cat_ID = scn.nextLine();}       // break;
                    return list;  
            }
       
        else{
            ArrayList em = new ArrayList<>();
            System.out.println("No categories!!");
            return em;
        }
        
           
    }
    void auth_admin(String x,String a, String y,String b){
        Scanner input = new Scanner(System.in);
        System.out.println("Dear Admin,");
        System.out.println("Please enter you username and password");
        System.out.print("Username: ");
        String id = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        if ((id.equals(x)) && (password.equals(y))){
            System.out.println("Welcome Mr."+x+"!!!");
        }
        else if((id.equals(a)) && (password.equals(b))){
            System.out.println("Welcome Mr."+a+"!!!");
        }
        else{
            System.out.println("Wrong Password or Username!!");
            System.out.println("Press 0 to try again or Press 1 to exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            if (choice==1)
            System.exit(0);
            else if (choice==0)
            auth_admin(x,a,y,b);

        }
    }
    void admin_menu()
    {
        System.out.println("1) Add category");
        System.out.println("2) Delete category");
        System.out.println("3) Add Product");
        System.out.println("4) Delete Product");
        System.out.println("5) Set Discount on Product");
        System.out.println("6) Add giveaway deal");
        System.out.println("7) Back");
    }
    
       
}

class Customer
{   
    static void register(Map<String,List<String>> cust_id_pass)
        {   
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter Name: ");
            String name = scn.nextLine();
            System.out.print("Enter Email: ");
            String email = scn.nextLine();
            System.out.print("Enter Ph. No.: ");
            String phn = scn.nextLine();
            System.out.print("Enter Password: ");
            String pass = scn.nextLine();
            
            if(cust_id_pass.containsKey(email) == false){
                ArrayList List = new ArrayList<>();
                List.add(name);
                List.add(pass);
                List.add("NORMAL");
                cust_id_pass.put(email,List);
                System.out.println("Registered Successfully!!");
            }
            else{
                System.out.println("Already registered!!");
                System.out.println("Login In!!");
            }
            
        }
    // abstract class Cust_details{
    //     Scanner scn = new Scanner(System.in);
    //     protected String cust_id;
    //     private String pass;
    //     public String getCust_id() {
    //         return cust_id;
    //     }
    //     public static void setCust_id(String cust_id) {
    //         this.cust_id = cust_id;
    //     }
    //     public String getPass() {
    //         return pass;
    //     }
    //     public static void setPass(String pass) {
    //         this.pass = pass;
    //     }
    // }
    // class cust_1 extends Cust_details{
    //     static void register(Map<String,List<String>> cust_id_pass)
    //     {   
    //         Scanner scn = new Scanner(System.in);
    //         System.out.print("Enter Name: ");
    //         String name = scn.nextLine();
    //         setCust_id(name);
    //         System.out.print("Enter Password: ");
    //         String pass = scn.nextLine();
    //         setPass(pass);
    //         System.out.println("Registered Successfully!!");
    //         ArrayList List = new ArrayList<>();
    //         List.add(pass);
    //         List.add("NORMAL");
    //         cust_id_pass.put(name,List);
    // }
    // }
    // class cust_2 extends Cust_details{

    // }
    // class cust_3 extends Cust_details{

    // }
    // class cust_4 extends Cust_details{

    // }
    static void log_choice(){
        
        System.out.println("1) Sign up");
        System.out.println("2) Log in");
        System.out.println("3) Back");
    }
    static abstract class iscoop
    {
        


    }
    static class elc extends iscoop
    {

    }
    static class pc extends iscoop
    {

    }    
       
    // static void signup(Map<String,List<String>> list, int is_logged)
    //     {   
    //         Scanner scn = new Scanner(System.in);
    //         String a = "Null";
    //         System.out.println("Enter Name: ");
    //         String id = scn.nextLine();
    //         System.out.println("Enter Password");
    //         String pass = scn.nextLine();
            
    //         if(list.containsKey(id))
    //         {
    //             if(((list.get(id)).get(0)).equals(pass))
    //             {
    //                 System.out.println("Welcome Mr. "+id);
    //                 System.out.println("Logged in!!");
    //                 is_logged = 1;
    //             }
    //             else{
    //                 System.out.println("Wrong Password!!");
    //             }
    //         }
            
    //         else
    //         {
                
    //             ArrayList<String> cust_id_pass_list = new  ArrayList<String>();
    //             cust_id_pass_list.add(pass);
    //             cust_id_pass_list.add("NORMAL");
    //             list.put(id, cust_id_pass_list);
    //             System.out.println("Registered Successfully");
    //             System.out.println("1) Sign up or Log in");
    //             System.out.println("2) Back");
    //             System.out.print("Enter you choice: ");
    //             int enter = scn.nextInt();
    //             switch(enter)
    //             {
    //                 case 1:
    //                     scn.nextLine();
    //                     signup(list, is_logged);
                        
    //                     break;
    //                 case 2:
    //                     break;        
    //             }
    //         }
    //         System.out.println("f"+is_logged);

    //     }
    static boolean login(Map<String,List<String>> cust_id_pass, String email, String pas)
    {   
        boolean log = false;
        
        if((cust_id_pass.containsKey(email)) && ((cust_id_pass.get(email).get(1)).equals(pas)))
        {
            System.out.println("Hello Mr. "+cust_id_pass.get(email).get(0));
            log = true;
        }
        else if((cust_id_pass.size()==0))
        {
            System.out.println("Sign up First!!");
        }
        else
        {
            System.out.println("Wrong credentials!!");
        }
    
        return log;

    }
    static void cust_menu()
    {
        System.out.println("1) Browse Products");
        System.out.println("2) Browse Deals");    
        System.out.println("3) Add a product to cart");
        System.out.println("4) Add products in deal to cart");
        System.out.println("5) View coupons");
        System.out.println("6) Check A/C balance");
        System.out.println("7) View cart");
        System.out.println("8) Empty cart");
        System.out.println("9) Checkout Cart");
        System.out.println("10) Upgrade status");
        System.out.println("11) Recharge wallet");
        System.out.println("12) Back");

    }   
    static abstract class coupon{
        int min = 5;  
        int max = 15;  
        int c1= (int)(Math.random()*(max-min+1)+min);
        int c2= (int)(Math.random()*(max-min+1)+min);
        int c3= (int)(Math.random()*(max-min+1)+min);
        int c4= (int)(Math.random()*(max-min+1)+min);

    } 
    static class Elite extends coupon{
       
    }
    static class Prime extends coupon{
        
    }
}