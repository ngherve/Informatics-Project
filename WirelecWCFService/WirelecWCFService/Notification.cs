using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WirelecWCFService
{
    public class Notification
    {
        [DataMember]
        public int N_ID { get; set; }
        [DataMember]
        public int UserID { get; set; }
        [DataMember]
        public string Message { get; set; }
        [DataMember]
        public string N_Datetime { get; set; }
        [DataMember]
        public string N_Email { get; set; }
    }
}