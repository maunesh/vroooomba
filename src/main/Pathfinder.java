package main;
import java.util.ArrayList;


public class Pathfinder {
	ShortGrid grid;
	
	public Pathfinder(ShortGrid g) {
		this.grid = g;
	}
	
	ArrayList<Vertex> findPath(Vertex source, Vertex dest) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		boolean pathFound = false;
		Vertex next = new Vertex(source.posX(), source.posZ());
		
		while(!pathFound) {	
			boolean optimalMove = false;
			if(dest.posX() == next.posX() && dest.posZ() == next.posZ() ) {
				path.add(new Vertex(next.posX(), next.posZ()));
				pathFound = true;
				break;
			}
			else if(dest.posX() < next.posX() && 
					grid.getStatus(next.posX() - 1, next.posZ()) != 2) {
				next.moveWest();
				path.add(new Vertex(next.posX(), next.posZ()));
				optimalMove = true;
			}
			else if(dest.posX() > next.posX() &&
					grid.getStatus(next.posX() + 1,  next.posZ()) != 2) {
				next.moveEast();
				path.add(new Vertex(next.posX(), next.posZ()));
				optimalMove = true;
			}
			else if(dest.posZ() < next.posZ() &&
					grid.getStatus(next.posX(), next.posZ() - 1) != 2) {
				next.moveSouth();
				path.add(new Vertex(next.posX(), next.posZ()));
				optimalMove = true;
			}
			else if(dest.posZ() > next.posZ() &&
					grid.getStatus(next.posX(), next.posZ() + 1) != 2) {
				next.moveNorth();
				path.add(new Vertex(next.posX(), next.posZ()));
				optimalMove = true;
			}		
			
			// If you couldn't move in the direction of the destination,
			// you still have to move
			if(!optimalMove) {
				if(grid.getStatus(next.posX() - 1, next.posZ()) != 2) {
					next.moveWest();
					path.add(new Vertex(next.posX(), next.posZ()));
				}
				else if(grid.getStatus(next.posX(), next.posZ() - 1) != 2) {
					next.moveSouth();
					path.add(new Vertex(next.posX(), next.posZ()));
				}
				else if(grid.getStatus(next.posX() + 1,  next.posZ()) != 2) {
					next.moveEast();
					path.add(new Vertex(next.posX(), next.posZ()));
				}
				else if(grid.getStatus(next.posX(), next.posZ() + 1) != 2) {
					next.moveNorth();
					path.add(new Vertex(next.posX(), next.posZ()));
				}
				else {
					
				}
			}
		}	
		
		return path;
	}
}
