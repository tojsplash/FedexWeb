package com.gen.serve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex> {
	public final String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}

}

class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}

public class Dijkstra {
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}

	public void shortestPath(String SCity, String DCity,int ID) {

		String sql = "";

		Vertex v0 = new Vertex("Northborough MA");
		Vertex v1 = new Vertex("Edison NJ");
		Vertex v2 = new Vertex("Allentown PA");
		Vertex v3 = new Vertex("Martinsburg WV");
		Vertex v4 = new Vertex("Charlotte NC");
		Vertex v5 = new Vertex("Atlanta GA");
		Vertex v6 = new Vertex("Orlando FL");
		Vertex v7 = new Vertex("Memphis TN");
		Vertex v8 = new Vertex("Baltimore MD");
		Vertex v9 = new Vertex("Grove City OH");
		Vertex v10 = new Vertex("Indianapolis IN");
		Vertex v11 = new Vertex("Detroit MI");
		Vertex v12 = new Vertex("New Berlin WI");
		Vertex v13 = new Vertex("Minneapolis MN");
		Vertex v14 = new Vertex("St. Louis MO");
		Vertex v15 = new Vertex("Kansas KS");
		Vertex v16 = new Vertex("Dallas TX");
		Vertex v17 = new Vertex("Houston TX");
		Vertex v18 = new Vertex("Denver CO");
		Vertex v19 = new Vertex("Salt Lake City U");
		Vertex v20 = new Vertex("Phoenix AZ");
		Vertex v21 = new Vertex("Los Angeles CA");
		Vertex v22 = new Vertex("Chino CA");
		Vertex v23 = new Vertex("Sacramento CA");
		Vertex v24 = new Vertex("Seattle WA");

		v0.adjacencies = new Edge[] { new Edge(v1, 221), new Edge(v2, 283),
				new Edge(v3, 150), new Edge(v4, 500), new Edge(v5, 600) };
		v1.adjacencies = new Edge[] { new Edge(v2, 75), new Edge(v3, 100),
				new Edge(v4, 175), new Edge(v5, 250), new Edge(v6, 350) };

		v2.adjacencies = new Edge[] { new Edge(v3, 75), new Edge(v4, 100),
				new Edge(v5, 125), new Edge(v6, 150), new Edge(v7, 175) };
		v3.adjacencies = new Edge[] { new Edge(v4, 75), new Edge(v5, 95),
				new Edge(v6, 145), new Edge(v7, 200), new Edge(v8, 247) };

		v4.adjacencies = new Edge[] { new Edge(v5, 100), new Edge(v6, 110),
				new Edge(v7, 130), new Edge(v8, 140), new Edge(v9, 190) };
		v5.adjacencies = new Edge[] { new Edge(v6, 50), new Edge(v7, 81.15),
				new Edge(v8, 130), new Edge(v9, 200), new Edge(v10, 250) };

		v6.adjacencies = new Edge[] { new Edge(v7, 100), new Edge(v8, 181.15),
				new Edge(v9, 222.15), new Edge(v10, 300.15),
				new Edge(v11, 311.15) };

		v7.adjacencies = new Edge[] { new Edge(v8, 100), new Edge(v9, 125),
				new Edge(v10, 140), new Edge(v11, 160), new Edge(v12, 180) };
		v8.adjacencies = new Edge[] { new Edge(v9, 45), new Edge(v10, 81.15),
				new Edge(v11, 120), new Edge(v12, 165), new Edge(v13, 200) };
		v9.adjacencies = new Edge[] { new Edge(v10, 110),
				new Edge(v11, 181.15), new Edge(v12, 201.15),
				new Edge(v13, 231.15), new Edge(v14, 251.15) };

		v10.adjacencies = new Edge[] { new Edge(v11, 111),
				new Edge(v12, 161.15), new Edge(v13, 181.15),
				new Edge(v14, 221.15), new Edge(v15, 250.15) };
		v11.adjacencies = new Edge[] { new Edge(v12, 25), new Edge(v13, 81.15),
				new Edge(v14, 100), new Edge(v15, 151.15),
				new Edge(v16, 181.15) };

		v12.adjacencies = new Edge[] { new Edge(v13, 111),
				new Edge(v14, 181.15), new Edge(v15, 200.15),
				new Edge(v16, 270.15), new Edge(v17, 381.15) };
		v13.adjacencies = new Edge[] { new Edge(v14, 150), new Edge(v15, 200),
				new Edge(v16, 281.15), new Edge(v17, 381.15),
				new Edge(v18, 481.15) };

		v14.adjacencies = new Edge[] { new Edge(v15, 221),
				new Edge(v16, 281.15), new Edge(v17, 299.15),
				new Edge(v18, 300.15), new Edge(v19, 325.15) };
		v15.adjacencies = new Edge[] { new Edge(v16, 75),
				new Edge(v17, 150.15), new Edge(v18, 181.15),
				new Edge(v19, 198), new Edge(v20, 250.15) };

		v16.adjacencies = new Edge[] { new Edge(v17, 150), new Edge(v18, 300),
				new Edge(v19, 381.15), new Edge(v20, 451.15),
				new Edge(v21, 481.15) };
		v17.adjacencies = new Edge[] { new Edge(v18, 101),
				new Edge(v19, 130.15), new Edge(v20, 181.15),
				new Edge(v21, 200.15), new Edge(v22, 281.15) };

		v18.adjacencies = new Edge[] { new Edge(v19, 22), new Edge(v20, 81.15),
				new Edge(v21, 181.15), new Edge(v22, 281.15),
				new Edge(v23, 381.15) };

		v19.adjacencies = new Edge[] { new Edge(v20, 101),
				new Edge(v21, 181.15), new Edge(v22, 221.15),
				new Edge(v23, 281.15), new Edge(v24, 341.15) };
		
		
		v20.adjacencies = new Edge[] { new Edge(v21, 125),
				new Edge(v22, 181.15), new Edge(v23, 250.15),
				new Edge(v24, 281.15), new Edge(v0, 381.15) };

		v21.adjacencies = new Edge[] { new Edge(v22, 111),
				new Edge(v23, 181.15), new Edge(v24, 281.15),
				new Edge(v0, 381.15), new Edge(v1, 481.15) };
		
		
		v22.adjacencies = new Edge[] { new Edge(v23, 221),
				new Edge(v24, 281.15), new Edge(v0, 381.15),
				new Edge(v1, 581.15), new Edge(v2, 681.15) };
		
		
		v23.adjacencies = new Edge[] { new Edge(v24, 221),
				new Edge(v0, 381.15), new Edge(v1, 481.15),
				new Edge(v2, 581.15), new Edge(v3, 681.15) };
		
		
		v24.adjacencies = new Edge[] { new Edge(v0, 480), new Edge(v1, 581.15),
				new Edge(v2, 681.15), new Edge(v3, 781.15),
				new Edge(v4, 881.15) };

		Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11,
				v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24 };

		if (SCity.equals("Northborough MA")) {
			computePaths(v0);
		}
		if (SCity.equals("Edison NJ")) {
			computePaths(v1);
		}
		if (SCity.equals("Allentown PA")) {

			computePaths(v2);
		}
		if (SCity.equals("Martinsburg WV")) {
			computePaths(v3);
		}
		if (SCity.equals("Charlotte NC")) {
			computePaths(v4);
		}

		if (SCity.equals("Atlanta GA")) {
			computePaths(v5);
		}

		if (SCity.equals("Orlando FL")) {

			computePaths(v6);
		}

		if (SCity.equals("Memphis TN")) {
			computePaths(v7);
		}
		if (SCity.equals("Baltimore MD")) {
			computePaths(v8);
		}
		if (SCity.equals("Grove City OH")) {

			computePaths(v9);
		}
		if (SCity.equals("Indianapolis IN")) {
			computePaths(v10);
		}
		if (SCity.equals("Detroit MI")) {
			computePaths(v11);
		}

		if (SCity.equals("New Berlin WI")) {
			computePaths(v12);
		}

		if (SCity.equals("Minneapolis MN")) {

			computePaths(v13);
		}

		if (SCity.equals("St. Louis MO")) {
			computePaths(v14);
		}
		if (SCity.equals("Kansas KS")) {
			computePaths(v15);
		}
		if (SCity.equals("Dallas TX")) {

			computePaths(v16);
		}
		if (SCity.equals("Houston TX")) {
			computePaths(v17);
		}
		if (SCity.equals("Denver CO")) {
			computePaths(v18);
		}

		if (SCity.equals("Salt Lake City U")) {
			computePaths(v19);
		}

		if (SCity.equals("Phoenix AZ")) {

			computePaths(v20);
		}

		if (SCity.equals("Los Angeles CA")) {

			computePaths(v21);
		}

		if (SCity.equals("Chino CA")) {
			computePaths(v22);
		}
		if (SCity.equals("Sacramento CA")) {
			computePaths(v23);
		}
		if (SCity.equals("Seattle WA")) {

			computePaths(v24);
		}



		List<Vertex> path = getShortestPathTo(v0);

		if (DCity.equals("Northborough MA")) {
			path = getShortestPathTo(v0);
		}
		if (DCity.equals("Edison NJ")) {
			path = getShortestPathTo(v1);
		}
		if (DCity.equals("Allentown PA")) {

			path = getShortestPathTo(v2);
		}
		if (DCity.equals("Martinsburg WV")) {
			path = getShortestPathTo(v3);
		}
		if (DCity.equals("Charlotte NC")) {
			path = getShortestPathTo(v4);
		}

		if (DCity.equals("Atlanta GA")) {
			path = getShortestPathTo(v5);
		}

		if (DCity.equals("Orlando FL")) {

			path = getShortestPathTo(v6);
		}

		if (DCity.equals("Memphis TN")) {
			path = getShortestPathTo(v7);
		}
		if (DCity.equals("Baltimore MD")) {
			path = getShortestPathTo(v8);
		}
		if (DCity.equals("Grove City OH")) {

			path = getShortestPathTo(v9);
		}
		if (DCity.equals("Indianapolis IN")) {
			path = getShortestPathTo(v10);
		}
		if (DCity.equals("Detroit MI")) {
			path = getShortestPathTo(v11);
		}

		if (DCity.equals("New Berlin WI")) {
			path = getShortestPathTo(v12);
		}

		if (DCity.equals("Minneapolis MN")) {

			path = getShortestPathTo(v13);
		}

		if (DCity.equals("St. Louis MO")) {
			path = getShortestPathTo(v14);
		}
		if (DCity.equals("Kansas KS")) {
			path = getShortestPathTo(v15);
		}
		if (DCity.equals("Dallas TX")) {

			path = getShortestPathTo(v16);
		}
		if (DCity.equals("Houston TX")) {
			path = getShortestPathTo(v17);
		}
		if (DCity.equals("Denver CO")) {
			path = getShortestPathTo(v18);
		}

		if (DCity.equals("Salt Lake City U")) {
			path = getShortestPathTo(v19);
		}

		if (DCity.equals("Phoenix AZ")) {

			path = getShortestPathTo(v20);
		}

		if (DCity.equals("Los Angeles CA")) {

			path = getShortestPathTo(v21);
		}

		if (DCity.equals("Chino CA")) {
			path = getShortestPathTo(v22);
		}
		if (DCity.equals("Sacramento CA")) {
			path = getShortestPathTo(v23);
		}
		if (DCity.equals("Seattle WA")) {

			path = getShortestPathTo(v24);
		}

	//	System.out.println("Path: " + path);
		String Path1 = path.toString();

		Path1 = Path1.substring(1, (Path1.length() - 1));

		System.out.println("New Path: " + Path1);

		String[] CitiesArray = Path1.split("\\s*,\\s*");

		String temp = CitiesArray[0];

		String[] Dist = { "Dist1", "Dist2", "Dist3", "Dist4", "Dist5", "Dist6",
				"Dist7", "Dist8", "Dist9", "Dist10", "Dist11", "Dist12",
				"Dist13", "Dist14", "Dist15", "Dist16", "Dist17", "Dist18",
				"Dist19", "Dist20", "Dist21", "Dist22", "Dist23", "Dist24", };

		String[] Nodes = { "Node1", "Node2", "Node3", "Node4", "Node5",
				"Node6", "Node7", "Node8", "Node9", "Node10", "Node11",
				"Node12", "Node13", "Node14", "Node15", "Node16", "Node17",
				"Node18", "Node19", "Node20", "Node21", "Node22", "Node23",
				"Node24", "Node25" };

		String sql1 = "";
		String sql2 = "";
		String sql3 = "INSERT INTO nodes (TrackingID,";
		String sql4 = ") VALUES ('" + ID + "',";
		String sql5 = ");";

		for (int i = 0; i < (CitiesArray.length); i++) {

			if (CitiesArray[i].equals(DCity)) {

				sql1 += "" + Nodes[i] + "";
				sql2 += "'" + CitiesArray[i] + "'";

			}

			else {

				Object dist = getDistance(CitiesArray[i], CitiesArray[i + 1]);

				sql1 += "" + Nodes[i] + "," + Dist[i] + ",";
				sql2 += "  '" + CitiesArray[i] + "','" + dist + "',";

			}

			// sql1 += sql1;
			// sql2 += sql2;

		}

		sql1 = sql3 + sql1;
		sql2 = sql4 + sql2 + sql5;
		sql = sql1 + sql2;

		try {
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/world";
			Class.forName(myDriver);
			Connection conn = DriverManager
					.getConnection(myUrl, "root", "1415");
			Statement st1 = conn.createStatement();
			st1.executeUpdate(sql);

			conn.close();
		}

		catch (Exception e) {
			System.err.println("Got an exception in Dijstra! ");
			System.err.println(e.getMessage());
		}

	}

	/*------------------------ To find the distance between any two nodes/cities-----------*/

	public Object getDistance(String Node1, String Node2) {

		String[] Cities = { "Northborough MA", "Edison NJ", "Allentown PA",
				"Martinsburg WV", "Charlotte NC", "Atlanta GA", "Orlando FL",
				"Memphis TN", "Baltimore MD", "Grove City OH",
				"Indianapolis IN", "Detroit MI", "New Berlin WI",
				"Minneapolis MN", "St. Louis MO", "Kansas KS", "Dallas TX",
				"Houston TX", "Denver CO", "Salt Lake City U", "Phoenix AZ",
				"Los Angeles CA", "Chino CA", "Sacramento CA", "Seattle WA"

		};

		Object[][] matrix = new Object[][] {
				{0,	"Northborough MA",	 "Edison NJ",	 "Allentown PA",	 "Martinsburg WV"	, "Charlotte NC"	, "Atlanta GA",	"Orlando FL"	, "Memphis TN"	, "Baltimore MD",	"Grove City OH"	, "Indianapolis IN"	, "Detroit MI",	"New Berlin WI"	, "Minneapolis MN",	"St. Louis MO"	, "Kansas KS",	"Dallas TX"	,"Houston TX"	, "Denver CO",	"Salt Lake City UT"	, "Phoenix AZ"	, "Los Angeles CA"	,"Chino CA"	, "Sacramento CA" ,	"Seattle WA"},
				{"Northborough MA",	0,	221,	283,	150,	500,	600,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{ "Edison NJ",	0,	0,	75,	100,	175,	250,	350,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				 {"Allentown PA",	0,	0,	0,	75,	100,	125,	150,	175,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				 {"Martinsburg WV",	0,	0,	0,	0,	75,	95,	145,	200,	247,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				 {"Charlotte NC",	0,	0,	0,	0,	0,	100,	110,	130,	140,	190,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{ "Atlanta GA",	0,	0,	0,	0,	0,	0,	50,	81.15,	130,	200,	250,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{"Orlando FL",	0,	0,	0,	0,	0,	0,	0,	100,	181.15,	222.15,	300.15,	311.15,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				 {"Memphis TN",	0,	0,	0,	0,	0,	0,	0,	0,	100,	125,	140,	160,	180,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{ "Baltimore MD",	0,	0,	0,	0,	0,	0,	0,	0,	0,	45,	81.15,	120,	165,	200,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{"Grove City OH",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	110,	181.15,	201.15,	231.15,	251.15,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				 {"Indianapolis IN",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	111,	161.15,	181.15,	221.15,	250.15,	0,	0,	0,	0,	0,	0,	0,	0,	0},
				{ "Detroit MI",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	25,	81.15,	100,	151.15,	181.15,	0,	0,	0,	0,	0,	0,	0,	0},
				{"New Berlin WI",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	111,	181.15,	200.15,	270.15,	381.15,	0,	0,	0,	0,	0,	0,	0},
				 {"Minneapolis MN",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	150,	200,	281.15,	381.15,	481.15,	0,	0,	0,	0,	0,	0},
				{"St. Louis MO",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	221,	281.15,	299.15,	300.15,	325.15,	0,	0,	0,	0,	0},
				{ "Kansas KS",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	75,	150.15,	181.15,	198,	250.15,	0,	0,	0,	0},
				{"Dallas TX",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	150,	300,	381.15,	451.15,	481.15,	0,	0,	0},
				{"Houston TX",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	101,	130.15,	181.15,	200.15,	281.15,	0,	0},
				{ "Denver CO",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	22,	81.15,	181.15,	281.15,	381.15,	0},
				{"Salt Lake City UT",	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	101,	181.15,	221.15,	281.15,	341.15},
				 {"Phoenix AZ",	381.15,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	125,	181.15,	250.15,	281.15},
				{ "Los Angeles CA",	381.15,	481.15,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	111,	181.15,	281.15},
				{"Chino CA",	381.15,	581.15,	681.15,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	221,	281.15},
				{ "Sacramento CA" ,	381.15,	481.15,	581.15,	681.15,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	221},
				{"Seattle WA",	480,	581.15,	681.15,	781.15,	881.15,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0}
				
		};

		int i = 0;
		for (i = 0; i < matrix[0].length; i++) {
			if (matrix[i][0].equals(Node1))
				break;
		}

		int j = 0;
		for (j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j].equals(Node2))
				break;
		}

	//	System.out.println(i + ": i ");

	//	System.out.println(j + ":j");
		
		if(i == matrix[0].length || j == matrix[0].length)
			return 99;
		
		
	//	System.out.println(matrix[i][j]);

		return matrix[i][j];
		
	

	}

	/*------------------------ To find the distance between any two nodes/cities-----------*/

}