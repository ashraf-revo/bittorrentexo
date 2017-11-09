package org.revo.torrent;

import org.revo.torrent.bencode.BencodeDecode;
import org.revo.torrent.bencode.BencodeException;
import org.revo.torrent.torrent.Torrent;
import org.revo.torrent.torrent.torrentdata.TorrentData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            Torrent torrent = new Torrent(getTorrentData("b.torrent"));
            torrent.startTorrent();
        } catch (IOException | BencodeException ignored) {
            System.out.println(ignored.getMessage());
        }


    }

    static TorrentData getTorrentData(String torrent) throws IOException, BencodeException {
        return new TorrentData((Map<String, Object>) BencodeDecode.bDecodeStream(new FileInputStream(torrent)));
    }

}
