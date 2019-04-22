using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AWilec
{
    public class wProduct
    {
        private string name;
        public string getName()
        {
            return name;
        }
        public void setName(string name)
        {
            this.name = name;
        }
        private int price;
        public int getPrice()
        {
            return price;
        }
        public void setPrice(int price)
        {
            this.price = price;
        }
        private string image;
        public string getImage()
        {
            return image;
        }
        public void setImage(string image)
        {
            this.image = image;
        }
        private int quantity;
        public int getQuantity()
        {
            return quantity;
        }
        public void setQuantity(int quantity)
        {
            this.quantity = quantity;
        }
        private string stat;

        public string getStatus()
        {
            return stat;
        }
        public void setStatus(string stat)
        {
            this.stat = stat;
        }


        public wProduct(string n,int p,string i,int q,string s)
        {
            name = n;
            price = p;
            image = i;
            quantity = q;
            stat = s;
        }
        
        static public List<wProduct> getProducts()
        {
            List<wProduct> list = new List<wProduct>();

            return list;
        }
    }
}