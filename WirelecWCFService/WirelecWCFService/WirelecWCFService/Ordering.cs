using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WirelecWCFService
{
    public class Ordering
    {
		  [DataMember]
            public int O_ID { get; set; }
			  [DataMember]
            public int C_ID { get; set; }
			  [DataMember]
            public string O_Status { get; set; }
			  [DataMember]
            public string O_Date { get; set; }
    }
}