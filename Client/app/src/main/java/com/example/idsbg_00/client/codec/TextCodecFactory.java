package com.example.idsbg_00.client.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.BufferDataException;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * A {@link ProtocolCodecFactory} that performs encoding and decoding between
 * a text line data and a Java string object.  This codec is useful especially
 * when you work with a text-based protocols such as SMTP and IMAP.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 */
public class TextCodecFactory implements ProtocolCodecFactory {

    private final TextEncoder encoder;

    private final TextDecoder decoder;

    /**
     * Creates a new instance with the current default {@link Charset}.
     */
    public TextCodecFactory() {
        this(Charset.defaultCharset());
    }

    /**
     * Creates a new instance with the specified {@link Charset}.  The
     * encoder uses a UNIX {@link LineDelimiter} and the decoder uses
     * the AUTO {@link LineDelimiter}.
     *
     * @param charset
     *  The charset to use in the encoding and decoding
     */
    public TextCodecFactory(Charset charset) {
        encoder = new TextEncoder(charset, LineDelimiter.UNIX);
        decoder = new TextDecoder(charset, LineDelimiter.AUTO);
    }

    /**
     * Creates a new instance of TextLineCodecFactory.  This constructor
     * provides more flexibility for the developer.
     *
     * @param charset
     *  The charset to use in the encoding and decoding
     * @param encodingDelimiter
     *  The line delimeter for the encoder
     * @param decodingDelimiter
     *  The line delimeter for the decoder
     */
    public TextCodecFactory(Charset charset, String encodingDelimiter, String decodingDelimiter) {
        encoder = new TextEncoder(charset, encodingDelimiter);
        decoder = new TextDecoder(charset, decodingDelimiter);
    }

    /**
     * Creates a new instance of TextLineCodecFactory.  This constructor
     * provides more flexibility for the developer.
     *
     * @param charset
     *  The charset to use in the encoding and decoding
     * @param encodingDelimiter
     *  The line delimeter for the encoder
     * @param decodingDelimiter
     *  The line delimeter for the decoder
     */
    public TextCodecFactory(Charset charset, LineDelimiter encodingDelimiter, LineDelimiter decodingDelimiter) {
        encoder = new TextEncoder(charset, encodingDelimiter);
        decoder = new TextDecoder(charset, decodingDelimiter);
    }

    public ProtocolEncoder getEncoder(IoSession session) {
        return encoder;
    }

    public ProtocolDecoder getDecoder(IoSession session) {
        return decoder;
    }

    /**
     * Returns the allowed maximum size of the encoded line.
     * If the size of the encoded line exceeds this value, the encoder
     * will throw a {@link IllegalArgumentException}.  The default value
     * is {@link Integer#MAX_VALUE}.
     * <p>
     * This method does the same job with {@link TextEncoder#getMaxLineLength()}.
     */
    public int getEncoderMaxLineLength() {
        return encoder.getMaxLineLength();
    }

    /**
     * Sets the allowed maximum size of the encoded line.
     * If the size of the encoded line exceeds this value, the encoder
     * will throw a {@link IllegalArgumentException}.  The default value
     * is {@link Integer#MAX_VALUE}.
     * <p>
     * This method does the same job with {@link TextEncoder#setMaxLineLength(int)}.
     */
    public void setEncoderMaxLineLength(int maxLineLength) {
        encoder.setMaxLineLength(maxLineLength);
    }

    /**
     * Returns the allowed maximum size of the line to be decoded.
     * If the size of the line to be decoded exceeds this value, the
     * decoder will throw a {@link BufferDataException}.  The default
     * value is <tt>1024</tt> (1KB).
     * <p>
     * This method does the same job with {@link TextDecoder#getMaxLineLength()}.
     */
    public int getDecoderMaxLineLength() {
        return decoder.getMaxLineLength();
    }

    /**
     * Sets the allowed maximum size of the line to be decoded.
     * If the size of the line to be decoded exceeds this value, the
     * decoder will throw a {@link BufferDataException}.  The default
     * value is <tt>1024</tt> (1KB).
     * <p>
     * This method does the same job with {@link TextDecoder#setMaxLineLength(int)}.
     */
    public void setDecoderMaxLineLength(int maxLineLength) {
        decoder.setMaxLineLength(maxLineLength);
    }
}
