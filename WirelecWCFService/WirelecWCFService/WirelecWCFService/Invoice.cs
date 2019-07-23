using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WirelecWCFService
{
    public class Invoice
    {
		  [DataMember]
            public int INV_ID { get; set; }
			  [DataMember]
            public int Quantity { get; set; }
			  [DataMember]
            public int Total_Price { get; set; }
			  [DataMember]
            public int C_ID { get; set; }
    }
}