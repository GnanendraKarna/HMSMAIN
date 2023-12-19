package com.hospital.entities.id;

import java.io.Serializable;
import java.util.Objects;

public class BlockId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer blockfloor;
	private Integer blockcode;

	public BlockId() {
	}

	public BlockId(Integer blockfloor, Integer blockcode) {
		super();
		this.blockfloor = blockfloor;
		this.blockcode = blockcode;
	}

	public Integer getBlockfloor() {
		return blockfloor;
	}

	public void setBlockfloor(Integer blockfloor) {
		this.blockfloor = blockfloor;
	}

	public Integer getBlockcode() {
		return blockcode;
	}

	public void setBlockcode(Integer blockcode) {
		this.blockcode = blockcode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(blockcode, blockfloor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlockId other = (BlockId) obj;
		return Objects.equals(blockcode, other.blockcode) && Objects.equals(blockfloor, other.blockfloor);
	}

	public String toString() {
		return "BlockId [blockfloor=" + blockfloor + ", blockcode=" + blockcode + "]";
	}

}
