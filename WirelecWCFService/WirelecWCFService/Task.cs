using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace WirelecWCFService
{
    public class Task
    {
        [DataMember]
        public int Task_ID { get; set; }
        [DataMember]
        public int UserID { get; set; }
        [DataMember]
        public string TaskContent { get; set; }
        [DataMember]
        public string Start_Date { get; set; }
        [DataMember]
        public string End_Date { get; set; }
        [DataMember]
        public string Priority { get; set; }
        [DataMember]
        public string Status { get; set; }
        [DataMember]
        public string T_Type { get; set; }

    }
}