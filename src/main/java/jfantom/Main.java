package jfantom;

import jfantom.util.ExecService;

public class Main {

	/**
	 * DNSaddress initializes ip
	 */
	public static final String[] DNSaddress = new String[]{
		"localhost:3001",
		"localhost:3002",
		"localhost:3003",
//		"localhost:3004",
//		"localhost:3005",
//		"localhost:3006",
//		"localhost:3007",
//		"localhost:3008",
//		"localhost:3009",
//		"localhost:3010",
//		"localhost:3011",
//		"localhost:3012",


		//"3003",
		//"3004",
	};

	public static void main(String[] args) {
		//Initialize
		String myName = args[0];

		//Operachain start
		OperaChain oc = OperaChain.OpenOperaChain(myName);
		oc.MyGraph = oc.NewGraph();
		switch (args[1]) {
		case "run":
			ExecService.go(() -> oc.receiveServer());

			ExecService.go(() -> oc.Sync());

			try {
				Thread.sleep(300 * 1000); // 300 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		case "print":
			oc.PrintChain();

		default:
			System.out.println("Fault command!");
		}
	}
}

