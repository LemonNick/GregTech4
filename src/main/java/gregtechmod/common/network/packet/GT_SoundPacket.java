package gregtechmod.common.network.packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;

public class GT_SoundPacket extends GT_Packet {
	public int aX;
	public int aY;
	public int aZ;
	public String aSoundName;
	public float aSoundStrength;
	public float aSoundModulation;
	
	public GT_SoundPacket() {}
	
	public GT_SoundPacket(String soundName, int x, int y, int z, float volume, float modulation) {
		this.aSoundName = soundName;
		this.aX = x;
		this.aY = y;
		this.aZ = z;
		this.aSoundStrength = volume;
		this.aSoundModulation = modulation;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		aX = buf.readInt();
		aY = buf.readInt();
		aZ = buf.readInt();
		aSoundStrength = buf.readFloat();
		aSoundModulation = buf.readFloat();
		aSoundName = ByteBufUtils.readUTF8String(buf);
		super.fromBytes(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(aX);
		buf.writeInt(aY);
		buf.writeInt(aZ);
		buf.writeFloat(aSoundStrength);
		buf.writeFloat(aSoundModulation);
		ByteBufUtils.writeUTF8String(buf, aSoundName);
		super.toBytes(buf);
	}
	
}