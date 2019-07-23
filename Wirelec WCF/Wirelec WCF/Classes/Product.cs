﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace Wirelec_WCF
{
    public class Product
    {
        [DataMember]
        public int P_ID { get; set; }
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