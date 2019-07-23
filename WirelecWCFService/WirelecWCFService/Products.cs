using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WirelecWCFService
{
    public class Products
    {
       /* private string v1;
        private int v2;
        private string v3;
        private int v4;
        private string v5;
        private string v6;
        private int v7;
        private int v;
        private string v8;
        private int v13;
        private int v9;
        private string v10;
        private int v11;
        private string v12;

        public Products()
        {
        }

        public Products(string v1, int v2, string v3, int v4, string v5, string v6, int v7)
        {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
            this.v4 = v4;
            this.v5 = v5;
            this.v6 = v6;
            this.v7 = v7;
        }

        public Products(int v, string v8, int v9, string v10, int v11, string v6, string v12, int v13)
        {
            this.v = v;
            this.v13 = v13;
            this.v9 = v9;
            this.v10 = v10;
            this.v11 = v11;
            this.v6 = v6;
            this.v12 = v12;
            this.v8 = v8;
        }
        */
			[DataMember]
            public string P_Name { get; set; }
            [DataMember]
            public int P_Price { get; set; }
            [DataMember]
            public string P_Image { get; set; }
            [DataMember]
            public int P_Quantity { get; set; }
            [DataMember]
            public string Supplier_Name { get; set; }
            [DataMember]
            public string P_Type { get; set; }
            [DataMember]
            public int W_ID { get; set; }
        }
    }

