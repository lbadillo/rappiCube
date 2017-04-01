package rappi.cubeSummation.controller;

import java.util.HashMap;
import rappi.cubeSummation.model.Cube;

public class Operations {

	@SuppressWarnings("rawtypes")
	private HashMap matrix = new HashMap();

	@SuppressWarnings("unchecked")
	public int updateMatrix(int x, int y, int z, int value, int siga) {
		if (x > 0 && y > 0 && z > 0) {
			Cube c = new Cube();
			c.setValue(value);
			c.setxCoordinate(x);
			c.setyCoordinate(y);
			c.setzCoordinate(z);
			if (siga == 0)
				matrix.clear();
			matrix.put("" + c.getKey(), c);
		}
		return value;

	}

	public int queryMatrix(int x1, int y1, int z1, int x2, int y2, int z2, int siga) {
		int x = x1, y = y1, z = z1, total = 0, hkey = 0;
		Cube val = new Cube(), val2;
		if (siga == 0) {
			matrix.clear();
		} else {
			while (x <= x2) {
				while (y <= y2) {
					while (z <= z2) {
						hkey = val.getPublicKey(x, y, z);
						if (matrix.containsKey("" + hkey)) {
							val2 = (Cube) matrix.get("" + hkey);
							total += val2.getValue();
						}
						z++;
					}
					y++;
					z = z1;
				}
				x++;
				y = y1;
			}
		}
		return total;
	}

	public HashMap getMatrix() {
		return matrix;
	}

	public void setMatrix(HashMap matrix) {
		this.matrix = matrix;
	}

}
